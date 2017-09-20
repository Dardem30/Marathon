package by.service;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

@Service
public class AnalyzerTextService {
    public List analyzer(String a) throws IOException {//this method check all repeatable words
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\HP\\IdeaProjects\\RestSpringTokinaizer\\"+a)),"UTF-8"));
        String f;
        Map<String, Integer> map = new HashMap<String, Integer>();
        while ((f = bufferedReader.readLine()) != null) {
            StringTokenizer tokenizer = new StringTokenizer(f, " \t\n\r,:-.!?");
            while (tokenizer.hasMoreTokens()) {
                String s = tokenizer.nextToken();
                if(s.length()>2) {
                    Integer value = map.get(s);
                    if (value != null) {
                        map.put(s, value + 1);
                    } else {
                        map.put(s, 1);
                    }
                }
            }
        }
        List list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue()-a.getValue();//Here, we are turning the list
            }
        });
        if(list.size()>10){
            ArrayList newList = new ArrayList();
            for(int i = 0; i<10; i++){
                newList.add(list.get(i));
            }
            return newList;
        }
        return list;
    }
    public String check(String a) throws IOException {//It checks brackets
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\HP\\IdeaProjects\\RestSpringTokinaizer\\"+a))));
        int f;
        int c=0;
        int v=0;
        int b=0;
        while ((f=bufferedReader.read())!=-1) {
            String s= String.valueOf((char)f);
            StringTokenizer stringTokenizer=new StringTokenizer(s, " \0\n\t\r,.!?");
            while (stringTokenizer.hasMoreTokens()){
                String s1=stringTokenizer.nextToken();
                if(c==0 && Objects.equals(s1, "(")){
                    c++;
                }
                else if(c==0 && Objects.equals(s1, ")")){
                    c+=100000;
                }
                else if(c>=1 && Objects.equals(s1, "(")){
                    c++;
                }
                else if(c>=1 && Objects.equals(s1, ")")){
                    c--;
                }
                if(v==0 && Objects.equals(s1, "{")){
                    v++;
                }
                else if(v==0 && Objects.equals(s1, "}")){
                    v+=100000;
                }
                else if(v>=1 && Objects.equals(s1, "{")){
                    v++;
                }
                else if(c>=1 && v>=1 && Objects.equals(s1, "}")){
                    v--;
                }
                if(b==0 && Objects.equals(s1, "[")){
                    b++;
                }
                else if(b==0 && Objects.equals(s1, "]")){
                    b+=100000;
                }
                else if(b>=1 && Objects.equals(s1, "[")){
                    b++;
                }
                else if(b>=1 && Objects.equals(s1, "]")){
                    b--;
                }
            }
        }
        if(c==0 && v==0 && b==0){
            return "correct";
        }else {
            return "incorrect";
        }
    }
}
