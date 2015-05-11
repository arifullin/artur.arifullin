package ru.itis.group403.arifullin;

import java.util.ArrayList;

public class Find {
    Point root;
    Point end;
    private boolean stend(char[][] desk){
        int count = 0;
        for (int i = 0; i <desk.length ; i++) {
            for (int j = 0; j <desk[i].length ; j++) {
                if (desk[i][j] == 'H'&&count==0){
                    root = new Point(i,j);
                    root.setPrevious(null);
                    count++;
                }else if (desk[i][j] == 'H'&&count==1){
                    end = new Point(i,j);
                    count++;
                }else if (desk[i][j] == 'H'&&count>1){
                    count++;
                }
            }
        }
        if (count!=2){
            return false;
        }else return true;
    }
    private ArrayList<Point> checkMove(Point x,char[][] desk){
        ArrayList<Point> move = new ArrayList();
        if (x.getX()+2<desk.length&&x.getY()+1<desk.length&&desk[x.getX()+2][x.getY()+1]!='*'){
            move.add(new Point(x.getX()+2,x.getY()+1));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()+2<desk.length&&x.getY()-1>=0&&x.getY()-1<desk.length&&desk[x.getX()+2][x.getY()-1]!='*'){
            move.add(new Point(x.getX()+2,x.getY()-1));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()-2<desk.length&&x.getX()-2>=0&&x.getY()+1<desk.length&&desk[x.getX()-2][x.getY()+1]!='*'){
            move.add(new Point(x.getX()-2,x.getY()+1));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()-2<desk.length&&x.getY()-1>=0&&x.getX()-2>=0&&x.getY()-1<desk.length&&desk[x.getX()-2][x.getY()-1]!='*'){
            move.add(new Point(x.getX()-2,x.getY()-1));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()+1<desk.length&&x.getY()+2<desk.length&&desk[x.getX()+1][x.getY()+2]!='*'){
            move.add(new Point(x.getX()+1,x.getY()+2));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()-1<desk.length&&x.getX()-1>=0&&x.getY()+2<desk.length&&desk[x.getX()-1][x.getY()+2]!='*'){
            move.add(new Point(x.getX()-1,x.getY()+2));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()+1<desk.length&&x.getY()-2>=0&&x.getY()-2<desk.length&&desk[x.getX()+1][x.getY()-2]!='*'){
            move.add(new Point(x.getX()+1,x.getY()-2));
            move.get(move.size()-1).setPrevious(x);
        }
        if (x.getX()-1<desk.length&&x.getX()-1>=0&&x.getY()-2>=0&&x.getY()-2<desk.length&&desk[x.getX()-1][x.getY()-2]!='*'){
            move.add(new Point(x.getX()-1,x.getY()-2));
            move.get(move.size()-1).setPrevious(x);
        }
        return move;
    }
    public String find(char[][] desk) {
        if (!stend(desk)) {
            return "Invalid input";
        }
        return find(desk,checkMove(root,desk));
    }
    private String find(char[][] desk,ArrayList<Point> previos){
        for (int i = 0; i < previos.size(); i++) {
            if (previos.get(i).getX() == end.getX()&&previos.get(i).getY() == end.getY()){
                String result = new String();
                Point x = previos.get(i);
                int count = 0;
                result +=" |x="+x.getX()+" y="+x.getY()+"|";
                while (x.getPrevious() != null){
                    x = x.getPrevious();
                    result +=" |x="+x.getX()+" y="+x.getY()+"|";
                    count++;
                }
                return result+"  length="+count;
            }
        }
        ArrayList<Point> next = new ArrayList<Point>();
        ArrayList<Point> temp;
        for (int i = 0; i < previos.size(); i++) {
            temp = checkMove(previos.get(i),desk);
            for (int j = 0; j < temp.size(); j++) {
                next.add(temp.get(j));
            }
        }
        return find(desk,next);
    }
    public static void main(String[] args) {
        char[][] desk = {{0,0,0,0,0},
                         {0,0,0,0,0},
                         {0,0,'H',0,0},
                         {0,'H',0,0,0},
                         {0,0,0,0,0}};
        Find find = new Find();
        System.out.println(find.find(desk));

    }
}
