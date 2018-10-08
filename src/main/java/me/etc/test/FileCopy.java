package me.etc.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopy {

	public static void main(String[] args) {
		String sFileInfo = "E:\\project\\EDU\\projectClient\\test1\\test1.txt";
		getFileInfo(sFileInfo);
		fileCopy(sFileInfo);
	}

	private static void fileCopy(String sInput) {
		File fileFrom = new File(sInput);
		String sTarget = "E:\\project\\EDU\\projectClient\\test2\\test1.txt";
		if(fileFrom.exists()){
			try {
				Files.copy(fileFrom.toPath(), new File(sTarget).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }else{
	        System.out.println("������ ã�� �� �����ϴ�. ");
	    }
		
	}
	
	private static void getFileInfo(String sInput) {
		// FileTest project �������� filefolder	est.txt  ������ ��ü�� �����Ѵ�.
        // �� �̽������� ���ڷ� �νĵǹǷ� \\ -> \ �� ����Ѵ�.

		File file = new File(sInput);
		// ��ο� ������ �����ϸ�
        if(file.exists()){
            
            try{
                
                System.out.println("getName: " + file.getName());  // ���� �̸� ���
                System.out.println("getPath: " + file.getPath());    // ���� ��� ��� 
                // ���� ���� ��� ���              
                System.out.println("getAbsolutePath : "+ file.getAbsolutePath());  
                // ���� ���� ��� ���
                System.out.println("getCanonicalPath : "+ file.getCanonicalPath()); 
                // ���� ���� ���
                System.out.println("getParent : " + file.getParent());   
                
           // ������ ����/�б� ���� üũ
          if(file.canWrite()) System.out.println(file.getName() + "�� �� �� �ֽ��ϴ�.");
          if(file.canRead()) System.out.println(file.getName()+ "�� ���� �� �ֽ��ϴ�.");
                
                // ��ü�� ����, ���� ���� üũ
                if(file.isFile()){
                    System.out.println(file.getName() + "�� �����Դϴ�.");
                }else if(file.isDirectory()){
                    System.out.println(file.getName() + "�� �����Դϴ�.");
                }else{
                    System.out.println(file.getName() + "�� ���ϵ� ������ �ƴմϴ�.");
                }
                
          // ���� ���� ���� ���
          System.out.println(file.getName() + "�� ���̴� "+ file.length() + " �Դϴ�.");
            
            }catch(IOException e){
                System.err.println(e);
            }
        
        }else{
            System.out.println("������ ã�� �� �����ϴ�. ");
        }

	}
}


/*
 * ��������Ʈ ����
 * http://hyeonstorage.tistory.com/233 [������ �ϰ� �;��]
 */
