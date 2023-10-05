


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        String ans = input.nextLine().toLowerCase();

        int numN = Integer.parseInt(input.nextLine());

        String str=input.nextLine().toLowerCase();

        String[] sarr1=str.split(" ");

        str=input.nextLine().toLowerCase();

        String[] sarr2=str.split(" ");

        ArrayList<String> list1= new ArrayList<>();
        ArrayList<String> list2= new ArrayList<>();
        ArrayList<Character> list3= new ArrayList<>();
        ArrayList<Character> list4= new ArrayList<>();


        Map<Character,Character> map = new HashMap<>();

        for(int i=0;i<26;i++) {
            map.put((char) ('a'+i),' ');
        }
        for(String temp:sarr1) {
            boolean joongbok=false;
            for(int i=0;i<temp.length()-1;i++) {
                for(int j=i+1;j<temp.length();j++) {
                    if(temp.charAt(i)==temp.charAt(j)) {
                        joongbok=true;
                        break;
                    }
                }

            }
            if(joongbok)
                list1.add(temp);
        }
        for(String temp:sarr2) {
            boolean joongbok=false;
            for(int i=0;i<temp.length()-1;i++) {
                for(int j=i+1;j<temp.length();j++) {
                    if(temp.charAt(i)==temp.charAt(j)) {
                        joongbok=true;
                        break;
                    }
                }

            }
            if(joongbok)
                list2.add(temp);
        }
        ArrayList<String> list5= new ArrayList(Arrays.asList(sarr1));
        ArrayList<String> list6= new ArrayList(Arrays.asList(sarr2));

        for(String temp:list1) {
            list5.remove(temp);
        }
        for(String temp:list2) {
            list6.remove(temp);
        }
        boolean[] search2=new boolean[list1.size()];
        for(int i=0;i<list1.size();i++) {
            list3= new ArrayList<>();
            list4= new ArrayList<>();
            for(int j=0;j<list2.size();j++) {
                boolean search=false;
                if(list1.get(i).length()!=list2.get(j).length())
                    continue;
                if((search2[j]))
                    continue;
                else {
                    for(int x=0;x<list1.get(i).length();x++) {
                        if(map.get(list1.get(i).charAt(x))==' ') {
                            if((list3.contains(list1.get(i).charAt(x))&&!list4.contains(list2.get(j).charAt(x))))
                            {
                                list3.clear();
                                list4.clear();
                                search=true;
                                break;
                            }
                            list3.add(list1.get(i).charAt(x));
                            list4.add(list2.get(j).charAt(x));
                        }
                        else if(map.get(list1.get(i).charAt(x))!=' '&&map.get(list1.get(i).charAt(x))==list2.get(j).charAt(x)) {
                            continue;
                        }
                        else {
                            list3.clear();
                            list4.clear();
                            search=true;
                            break;
                        }
                    }
                    for(int g=0;g<list3.size();g++) {
                        map.put(list3.get(g), list4.get(g));
                    }
                    if(!search) {
                        search2[j]=true;
                        break;
                    }
                }
            }
        }
        list3.clear();
        list4.clear();
        search2=new boolean[list5.size()];
        for(int i=0;i<list5.size();i++) {
            list3= new ArrayList<>();
            list4= new ArrayList<>();
            for(int j=0;j<list5.size();j++) {
                boolean search=false;
                if(list5.get(i).length()!=list6.get(j).length())
                    continue;
                if((search2[j]))
                    continue;
                else {
                    for(int x=0;x<list5.get(i).length();x++) {
                        if(map.get(list5.get(i).charAt(x))==' ') {
                            if((list3.contains(list5.get(i).charAt(x))&&!list4.contains(list6.get(j).charAt(x))))
                            {
                                list3.clear();
                                list4.clear();
                                search=true;
                                break;
                            }
                            list3.add(list5.get(i).charAt(x));
                            list4.add(list6.get(j).charAt(x));
                        }
                        else if(map.get(list5.get(i).charAt(x))!=' '&&map.get(list5.get(i).charAt(x))==list6.get(j).charAt(x)) {
                            continue;
                        }
                        else {

                            list3.clear();
                            list4.clear();
                            search=true;
                            break;
                        }
                    }
                    for(int g=0;g<list3.size();g++) {
                        map.put(list3.get(g), list4.get(g));
                    }
                    if(!search) {
                        search2[j]=true;
                        break;
                    }
                }
            }
        }
        String answer="the quick brown fox jumps over the lazy dog";
        Map<Character,Character> Ansmap = new HashMap<>();
        int count = 0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i) != '?') {
                Ansmap.put(ans.charAt(i), ans.charAt(i));
                char chh = ans.charAt(i);
                if(chh == ans.charAt(i)) {
                    count ++;
                }
            }
        }char[] charTo = {'a', 'c', 'y', 'z', 'd', 'x','w'}; char[] adjust = {'p','q','w', 'b', 'g','z','t'};
        if(numN <= 5) {
            for (int i = 0; i < charTo.length; i++) {
                char originalChar = charTo[i];
                char newChar = adjust[i];
                map.put(originalChar, newChar);
            }
        }
        for(int i=0;i<answer.length();i++){
            if(answer.charAt(i)==' ') {
                System.out.print(" ");
            } else if(ans.charAt(i) != '?') {
                System.out.print(Ansmap.get(ans.charAt(i)));
            }
            else
                System.out.print(map.get(answer.charAt(i)));
        }
        System.out.println();
    }

}
