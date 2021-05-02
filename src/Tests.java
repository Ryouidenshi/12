import org.junit.Test;
import org.junit.Assert;

public class Tests {

    @Test(expected = NumberFormatException.class)
    public void testEmptyString() {
        Integer.decode("");
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Integer.decode(null);
    }

    @Test(expected = NumberFormatException.class)
    public void testStringWord() {
        Integer.decode("strokavmestochisla");
    }

    @Test
    public void testPositiveNumber() {
        Assert.assertEquals(5, Integer.decode("+5").longValue());
    }

    @Test
    public void testNegativeNumber() {
        Assert.assertEquals(-5, Integer.decode("-5").longValue());
    }

    @Test
    public void testWithoutSign() {
        Assert.assertEquals(5, Integer.decode("5").longValue());
    }

    @Test
    public void testRadixFirst() {
        Assert.assertEquals(16, Integer.decode("0X10").longValue()); //16 СС
    }

    @Test
    public void testRadixSecond() {
        Assert.assertEquals(4660, Integer.decode("0X1234").longValue()); //16 СС
    }

    @Test
    public void testRadixThird() {
        Assert.assertEquals(4660, Integer.decode("#1234").longValue()); //16 СС
    }

    @Test
    public void testRadixFourth() {
        Assert.assertEquals(34, Integer.decode("#22").longValue()); //16 СС
    }

    @Test
    public void testRadixFifth() {
        Assert.assertEquals(16, Integer.decode("#10").longValue()); //16 СС
    }

    @Test
    public void testRadixSixth() {
        Assert.assertEquals(8, Integer.decode("010").longValue()); //8 СС
    }

    @Test
    public void testRadixSeventh() {
        Assert.assertEquals(80, Integer.decode("0120").longValue()); //8 СС
    }

    @Test
    public void testRadixEight() {
        Assert.assertEquals(656, Integer.decode("01220").longValue()); //8 СС
    }

    @Test
    public void testRadixNight() {
        Assert.assertEquals(144, Integer.decode("0220").longValue()); //8 СС
    }

    @Test
    public void testRadixTenth() {
        Assert.assertEquals(1, Integer.decode("01").longValue()); //8 СС
    }

    @Test(expected = NumberFormatException.class)
    public void testRadixEleventh() {
        Integer.decode("2#");
    }

    @Test(expected = NumberFormatException.class)
    public void testRadixTwenty() {
        Integer.decode("20X1");
    }


    @Test(expected = NumberFormatException.class)
    public void testSpace() {
        Integer.decode("21 2");
    }

    @Test(expected = NumberFormatException.class)
    public void testDouble() {
        Integer.decode("21,2");
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectStringFirst() {
        Integer.decode("- 212");
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectStringSecond() {
        Integer.decode("22+2");
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectStringThird() {
        Integer.decode("21-2");
    }

    @Test(expected = NumberFormatException.class)
    public void testIncorrectStringFourth() {
        Integer.decode("+ 212");
    }

    @Test
    public void testIntMinValue(){
        Assert.assertEquals(Integer.MIN_VALUE, Integer.decode("-2147483648").longValue());
    }

    @Test
    public void testIntMaxValue(){
        Assert.assertEquals(Integer.MAX_VALUE, Integer.decode("2147483647").longValue());
    }
}
