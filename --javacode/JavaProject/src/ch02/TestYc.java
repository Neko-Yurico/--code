package ch02;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Neko_Yurico
 * @description
 * @date 2021/4/15 22:02
 * ========================
 * WELCOME TO MY WEBSITE
 * https://nekoyurico.me/
 * ========================
 */

public class TestYc {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("c:/abc.txt");
        } catch (FileNotFoundException e) {
            //打印输出异常
            e.printStackTrace();
        }

        Mother mother  = new Mother();
        mother.bbb();
        //1.編譯時異常
        //讀取該路徑"c:/abc.txt"下的文件
	/* try {
		 FileReader fr = new FileReader("c:/abc.txt");
	 }catch(FileNotFoundException e) {
		//打印输出异常
			e.printStackTrace();
	 }*/
        int [] arr = new int[] {1,2,3};
        System.out.println(arr[2]);
    }
}

class Mother {

    private Boy b = null;

    // 构造器
    public Mother() {

        b = new Boy();

    }

    public void bbb() {
        // TODO Auto-generated method stub
        //调用带有异常的方法
        try {
            b.aaa();
        }catch(FileNotFoundException e) {
            e.printStackTrace();

        }

    }
}

class Boy {
    // throws 把异常抛给上层的调用者
    public  void aaa() throws FileNotFoundException{
        FileReader fr = new FileReader( "c:/abc.txt");
    }
}