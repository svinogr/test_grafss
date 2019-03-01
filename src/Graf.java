import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.*;

public class Graf {
    private static Stack<Item> stack = new Stack<>();
    private static int start = -1;

    public static void main(String[] args) {

        List<Item> list = new ArrayList<>();

        Item a = new Item("a");
        Item b = new Item("b");
        Item c = new Item("c");
        Item d = new Item("d");
        Item e = new Item("e");
        Item f = new Item("f");

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        a.getListNeighbors().put(b, 3);
        a.getListNeighbors().put(c, 2);
        a.getListNeighbors().put(d, 2);
        a.getListNeighbors().put(e, 2);

        b.getListNeighbors().put(a, 4);
        b.getListNeighbors().put(c, 1);
        b.getListNeighbors().put(d, 3);
        b.getListNeighbors().put(e,3);

        c.getListNeighbors().put(a, 4);
        c.getListNeighbors().put(b, 5);
        c.getListNeighbors().put(d, 2);
        c.getListNeighbors().put(e, 2);

        d.getListNeighbors().put(a, 2);
        d.getListNeighbors().put(b, 4);
        d.getListNeighbors().put(c, 5);
        d.getListNeighbors().put(e, 1);

        e.getListNeighbors().put(a, 2);
        e.getListNeighbors().put(b, 6);
        e.getListNeighbors().put(c, 2);
        e.getListNeighbors().put(d, 3);

        f.getListNeighbors().put(d, 4);
        f.getListNeighbors().put(e, 6);

     //   graf();
        topo();

    }

    private static void topo() {
        List<Item> list = setListForTopo();
        matricx(list);
        Item finis[] = new Item[list.size()];
        int n = list.size() - 1;
        while (list.size()>0) {

           Item curentItem = getItemWihoutSibl(list);

           if (curentItem == null) {
               System.out.println("есть цикл");
               break;
            }else {
               for(Item item : list){
                   item.getListNeighbors().remove(curentItem); // убираем из всех точек ведущих к ней
               }

               list.remove(curentItem);

               finis[n--] = curentItem;

           }


        }

        System.out.println("finish" + Arrays.toString(finis));


    }

    private static void matricx(List<Item> list) {
         final  int SIZE = list.size();
        int[][] matrix = new int[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++ ){
            Item item = list.get(i);

            for (int j = 0; j < SIZE; j++){
                Map<Item, Integer> listNeighbors = item.getListNeighbors();
                matrix[i][j] = 0;
                for(Map.Entry<Item, Integer> mapItem : listNeighbors.entrySet() ) {

                    if(list.indexOf(mapItem.getKey()) == j)
                    matrix[i][j] = 1;
                }
            }

        }

        for (int i = 0; i < SIZE; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }





    }

    private static Item getItemWihoutSibl(List<Item> list) {

        for( int i = 0; i < list.size(); i++ ){

            if(list.get(i).getListNeighbors().size() > 0){


                System.out.println(list.get(i).getName() +"  "+ list.get(i).getListNeighbors().size());
                continue;
            }else {
                System.out.println(list.get(i).getName()+ " нет насл");
                return list.get(i);

            }
        }


        return null;
    }

    private static List setListForTopo() {

        List<Item> list = new ArrayList<>();

        Item a = new Item("a");
        Item b = new Item("b");
        Item c = new Item("c");
        Item d = new Item("d");
        Item e = new Item("e");
        Item f = new Item("f");

        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);

        a.getListNeighbors().put(b, 3);
        a.getListNeighbors().put(c, 2);

        b.getListNeighbors().put(d, 3);
        b.getListNeighbors().put(e, 3);

        c.getListNeighbors().put(e, 2);

        d.getListNeighbors().put(e, 1);

        e.getListNeighbors().put(f, 3);

        return list;
    }


    private static void graf() {
        Item startPoint  = setPoint();

        stack.push(startPoint);
        startPoint.setChoosed(true);

        while (!stack.empty()) {

            Item itemCurrent = stack.peek();
            Item item = getUnvisited(itemCurrent);

            if (item == null) {

                stack.pop();
            } else {
               stack.push(item);
                System.out.println(itemCurrent+"--"+stack.peek());
               item.setChoosed(true);

            }

        }
    }

    private static Item setPoint() {
        Item a = new Item("a");
        Item b = new Item("b");
        Item c = new Item("c");
        Item d = new Item("d");
        Item e = new Item("e");
        Item f = new Item("f");

        a.getListNeighbors().put(b, 3);
        a.getListNeighbors().put(c, 2);
        a.getListNeighbors().put(d, 2);
        a.getListNeighbors().put(e, 2);

        b.getListNeighbors().put(a, 4);
        b.getListNeighbors().put(c, 1);
        b.getListNeighbors().put(d, 3);
        b.getListNeighbors().put(e,3);

        c.getListNeighbors().put(a, 4);
        c.getListNeighbors().put(b, 5);
        c.getListNeighbors().put(d, 2);
        c.getListNeighbors().put(e, 2);

        d.getListNeighbors().put(a, 2);
        d.getListNeighbors().put(b, 4);
        d.getListNeighbors().put(c, 5);
        d.getListNeighbors().put(e, 1);

        e.getListNeighbors().put(a, 2);
        e.getListNeighbors().put(b, 6);
        e.getListNeighbors().put(c, 2);
        e.getListNeighbors().put(d, 3);

        f.getListNeighbors().put(d, 4);
        f.getListNeighbors().put(e, 6);

        return a;
    }

    private static Item getUnvisited(Item item){
        Item itemNotChosed = null;
        Map<Item, Integer> map = item.getListNeighbors();
        if (map.size() != 0) {
            for (Map.Entry<Item, Integer> itemMap : map.entrySet()) {
                if (!itemMap.getKey().isChoosed()) {
                itemNotChosed = itemMap.getKey();
                //itemNotChosed.setChoosed(true);
                }

            }

        }
        return itemNotChosed;
    }


}