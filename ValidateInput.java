public class ValidateInput
{
    public boolean isInteger(String value)
    {
        try
        {
            int testCase = Integer.parseInt(value);

        }
        catch (NumberFormatException e)
        {
            return false;

        }

        return true;
    }
}
