package Lab2;

import java.io.*;

public class BookReader implements  Reader {
    private File book;

    BookReader(String BookLocation){
        book = new File(BookLocation);
    }

    @Override
    public void StreamReader()  {
        try {
            InputStream inputStream = new FileInputStream(book);
            byte[] data = new byte[1024];

            int i = inputStream.read(data);
            Dictionary dic = new Dictionary();

            while (i != -1) {

                String str = new String(data);
                System.out.println(str);
                String temp = "";

//                for (byte a:
//                     data) {
//                    System.out.println(a);
//                }
                for (int k=0; k < data.length ;k++ )
                    if (data[k] == (byte) 0){
                        temp = str.substring(0,k);
                        System.out.println(temp);
                        break;
                    }
                temp =  temp.replace("\n"," ");
                System.out.println(temp);
                String[] words = temp.split(" ");
                System.out.println(temp);
                for (int k=0; k< words.length; k++) {
                    dic.addWord(words[k]);
                }
                i = inputStream.read(data);
            }
            dic.Sort();
            String out = book.getParent() + File.separator + "out.txt";
            dic.WriteToFile(out);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void BufferedStream() {
        try {
            FileInputStream fileInputStream = new FileInputStream(book);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);


            byte[] data = new byte[1024];

            int i = bufferedInputStream.read(data);
            Dictionary dic = new Dictionary();


            while (i != -1) {

                String str = new String(data);
                String temp = "";
                for (int k=0; k < data.length ;k++ )
                    if (data[k] == (byte) 0){
                        temp = str.substring(0,k);
                        break;
                    }
                temp =  str.replace("\n"," ");
                String[] words = temp.split(" ");

                for (int k=0; k< words.length; k++) {
                    dic.addWord(words[k]);
                }
                i = bufferedInputStream.read(data);
            }

            dic.Sort();
            String out = book.getParent() + File.separator + "out.txt";
            dic.WriteToFile(out);

        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void Reader() {
        try {
            FileReader fileReader = new FileReader(book);
            char[] data = new char[1024];

            int i = fileReader.read(data);
            Dictionary dic = new Dictionary();

            while (i != -1) {

                String str = new String(data);
                String temp = "";
                for (int k=0; k < data.length ;k++ )
                    if (data[k] == (byte) 0){
                        temp = str.substring(0,k);
                        break;
                    }
                temp =  str.replace("\n"," ");
                String[] words = temp.split(" ");

                for (int k=0; k< words.length; k++) {
                    dic.addWord(words[k]);
                }
                i = fileReader.read(data);
            }

            dic.Sort();
            String out = book.getParent() + File.separator + "out.txt";
            dic.WriteToFile(out);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        BookReader b = new BookReader(""); // input file location
        b.BufferedStream();
    }
} 