
import java.util.ArrayList;
import java.util.List;

public interface ItemProcessor {
    String process(String item);
}

class MyItemProcessor implements ItemProcessor {

    @Override
    public String process(String item) {
        if ("FAIL".equals(item)) {
            System.err.println("Error processing item: FAIL. Skipping.");
            return null;
        }
        return item.toUpperCase() + "_processed_" + System.currentTimeMillis();
    }
}

class BatchJobRunner{
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        lst.add("apple");
        lst.add("banana");
        lst.add("FAIL");
        lst.add("oragne");
        lst.add("grape");
        int countSuccess = 0;
        int countFailed = 0 ;
        MyItemProcessor p = new MyItemProcessor();
        for(String s : lst)
        {
           String s3 =  p.process(s);
           if(s3 != null)
           {
                countSuccess++;
                System.out.println(s3);
           }else{
            countFailed++;
           }

        }
        System.out.println("Batch finished. Successfully processed: "+countSuccess+" , Failed: "+countFailed);
    }
}

//i would run locally using mysql .
//i would run using postgres and postman

//i would have to specify the version of the java for docker
