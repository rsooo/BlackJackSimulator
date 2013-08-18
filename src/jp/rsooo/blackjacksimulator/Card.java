package jp.rsooo.blackjacksimulator;

import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

public class Card
{
    public static enum Suit {SPADES, HEARTS, DIAMONDS, CLUBS};
    public static enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE};

    public static Image[][] card_images;
    public static Image card_back;
    public static Image busted_image, blackjack_image, twenty_one_image;
    public static final int CARD_WIDTH = 69;
    public static final int CARD_HEIGHT = 100;

    public Suit suit;
    public Rank rank;

    public boolean given_away = false;

    public static void LoadImages() throws IOException
    {
        int x, y, s, r, k;
        BufferedImage image = ImageIO.read(new File("data/cards.png"));

        card_images = new Image[4][];
        for(s=0; s<4; s++)
        {
            card_images[s] = new Image[13];
            y = image.getHeight() - (s + 2) * CARD_HEIGHT;
            for(r=0; r<13; r++)
            {
                if(r == 12)
                    k = 0;
                else
                    k = r + 1;
                x = k * CARD_WIDTH;
                card_images[s][r] = image.getSubimage(x, y, CARD_WIDTH, CARD_HEIGHT);
            }
        }
        busted_image = ImageIO.read(new File("data/busted.png"));
        blackjack_image = ImageIO.read(new File("data/blackjack.png"));
        twenty_one_image = ImageIO.read(new File("data/21.png"));
        card_back = ImageIO.read(new File("data/card_back.png"));
    }

    public Card(Card.Suit s, Card.Rank r)
    {
        suit = s;
        rank = r;
    }

    public Card()
    {
        suit = Suit.SPADES;
        rank = Rank.TWO;
    }

    public int Value()
    {
        return Value(rank);
    }

    Image CardImage()
    {
        int s, r;
        s = IDBySuit(suit);
        r = IDByRank(rank);
        return card_images[s][r];
    }

    String RankString()
    {
        return StringByRank(rank);
    }

    String SuitString()
    {
        return StringBySuit(suit);
    }

    String CardString()
    {
        return StringByCard(this);
    }

//	    void GiveToPlayer(Player p)
//	    {
//	        p.AddCard(this);
//	        given_away = true;
//	    }

    static int IDByRank(Card.Rank v)
    {
        switch(v)
        {
            case TWO:       return 0;
            case THREE:     return 1;
            case FOUR:      return 2;
            case FIVE:      return 3;
            case SIX:       return 4;
            case SEVEN:     return 5;
            case EIGHT:     return 6;
            case NINE:      return 7;
            case TEN:       return 8;
            case JACK:      return 9;
            case QUEEN:     return 10;
            case KING:      return 11;
            case ACE:       return 12;
        }
        return 0;
    }

    static Card.Rank RankByID(int v)
    {
        switch(v)
        {
            case 0:         return Card.Rank.TWO;
            case 1:         return Card.Rank.THREE;
            case 2:         return Card.Rank.FOUR;
            case 3:         return Card.Rank.FIVE;
            case 4:         return Card.Rank.SIX;
            case 5:         return Card.Rank.SEVEN;
            case 6:         return Card.Rank.EIGHT;
            case 7:         return Card.Rank.NINE;
            case 8:         return Card.Rank.TEN;
            case 9:         return Card.Rank.JACK;
            case 10:        return Card.Rank.QUEEN;
            case 11:        return Card.Rank.KING;
            case 12:        return Card.Rank.ACE;
        }
        return Card.Rank.TWO;
    }

    static Card.Suit SuitByID(int v)
    {
        switch(v)
        {
            case 0:         return Card.Suit.SPADES;
            case 1:         return Card.Suit.HEARTS;
            case 2:         return Card.Suit.DIAMONDS;
            case 3:         return Card.Suit.CLUBS;
        }
        return Card.Suit.SPADES;
    }

    static int IDBySuit(Card.Suit v)
    {
        switch(v)
        {
            case SPADES:    return 0;
            case HEARTS:    return 1;
            case DIAMONDS:  return 2;
            case CLUBS:     return 3;
        }
        return 0;
    }

    static String StringByRank(Card.Rank v)
    {
        switch(v)
        {
            case TWO:       return "2";
            case THREE:     return "3";
            case FOUR:      return "4";
            case FIVE:      return "5";
            case SIX:       return "6";
            case SEVEN:     return "7";
            case EIGHT:     return "8";
            case NINE:      return "9";
            case TEN:       return "10";
            case JACK:      return "Jack";
            case QUEEN:     return "Queen";
            case KING:      return "King";
            case ACE:       return "Ace";
        }
        return "";
    }

    static String StringBySuit(Card.Suit s)
    {
        switch(s)
        {
            case SPADES:        return "Spades";
            case HEARTS:        return "Hearts";
            case DIAMONDS:      return "Diamonds";
            case CLUBS:         return "Clubs";
        }
        return "";
    }

    static String StringByCard(Card c)
    {
        return c.RankString() + " of " + c.SuitString();
    }

    static int Value(Card.Rank v)
    {
        return Value(v, false);
    }

    static int Value(Card.Rank v, boolean ace_is_one)
    {
        switch(v)
        {
            case TWO:       return 2;
            case THREE:     return 3;
            case FOUR:      return 4;
            case FIVE:      return 5;
            case SIX:       return 6;
            case SEVEN:     return 7;
            case EIGHT:     return 8;
            case NINE:      return 9;
            case TEN:       return 10;
            case JACK:      return 10;
            case QUEEN:     return 10;
            case KING:      return 10;
            case ACE:       return ace_is_one ? 1 : 11;
        }
        return 0;
    }

}
