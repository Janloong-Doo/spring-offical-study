package com.janloong.utils;


import org.gjt.jclasslib.io.ClassFileWriter;
import org.gjt.jclasslib.structures.CPInfo;
import org.gjt.jclasslib.structures.ClassFile;
import org.gjt.jclasslib.structures.constants.ConstantUtf8Info;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author Janloong
 * @create 2017-09-13 9:07
 **/
public class ClassFileEditUtils {
    public static void main(String[] args) throws Exception {

        //String filePath = "C:\\GenEntity.class";
        String filePath = "C:\\Users\\Administrator\\Desktop\\codehelper\\PPValidator.class";
        FileInputStream fis = new FileInputStream(filePath);

        DataInput di = new DataInputStream(fis);
        ClassFile cf = new ClassFile();
        cf.read(di);
        CPInfo[] infos = cf.getConstantPool();

        int count = infos.length;
        for (int i = 0; i < count; i++) {
            if (infos[i] != null) {
                System.out.print(i);
                System.out.print(" = ");
                System.out.print(infos[i].getVerbose());
                System.out.print(" = ");
                System.out.println(infos[i].getTagVerbose());
                //if(i == 290){
                //    ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
                //    //uInfo.setBytes("booleanValue==false".getBytes());
                //    //uInfo.setString("booleanValue==false||true.toString");
                //    uInfo.setString("booleanValue()|| Boolean.valueOf(true)||Boolean.valueOf(true).toString");
                //    infos[i]=uInfo;
                //}
                if(i == 161){
                    ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
                    //uInfo.setBytes("booleanValue==false".getBytes());
                    //uInfo.setString("booleanValue==false||true.toString");
                    uInfo.setString("破解你麻痹");
                    infos[i]=uInfo;
                }
                Boolean a = true;
                String s = a.toString();
                boolean b = a.booleanValue();

                //if(i == 6){
                //    ConstantUtf8Info uInfo = (ConstantUtf8Info)infos[i];
                //    //uInfo.setBytes("java/lang/Boolean.booleanValue==false".getBytes());
                //    uInfo.setString("java/lang/Boolean.booleanValue==false");
                //    infos[i]=uInfo;
                //}
            }
        }
        cf.setConstantPool(infos);
        fis.close();
        File f = new File(filePath);
        ClassFileWriter.writeToFile(f, cf);
    }
}
