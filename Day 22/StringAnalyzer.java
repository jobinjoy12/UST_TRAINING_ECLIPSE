public class StringAnalyzer {
	public int countChar(String text, char c) {
		if(text == null){
            return 0;
        }else{
            if(text.isEmpty())
            {
                return 0;
            }else
            {
                int count =0;
                for(char a : text.toCharArray())
                {
                    if(a==c)
                    {
                        count++;
                    }
                }
                return count;
            }
        }
	}
}