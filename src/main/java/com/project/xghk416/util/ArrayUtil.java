package com.project.xghk416.util;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ArrayUtil {
    public static void getSonSet1(int i, List<String> aList, List<String> bList,List<List<String>> labelList){
        if(i>aList.size()-1){
            if(bList.size()<=0){
//                System.out.print("@");
            }else {
                /*for(int v:bList){
                    System.out.print(v+",");//可以直接用这种方法输出bList数组里所有值，但是每个子数组最后就会带逗号
                }*/
                String[] temp = new String[bList.size()];
                System.arraycopy(bList.toArray(),0,temp,0,bList.size());
                labelList.add(new ArrayList<>(Arrays.asList(temp)));
//                System.out.print(bList.get(0));
//                for(int m=1;m<bList.size();m++){
//                    System.out.print(","+bList.get(m));
//                }
            }
        }else {
            bList.add(aList.get(i));
            getSonSet1(i+1, aList, bList,labelList);
            int bLen=bList.size();
            bList.remove(bLen-1);
            getSonSet1(i+1, aList, bList,labelList);
        }
    }

    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
    public static <T> Boolean judgeHasSame(List<T> list){
        HashSet<T> hashSet = new HashSet<T>(list);
        return list.size() == hashSet.size();
    }

}
