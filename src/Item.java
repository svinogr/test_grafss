import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Item implements Comparable<Item>{
    private String name;
    private boolean choosed;
    private Map<Item, Integer> listNeighbors;

    public Item(String name) {
        this.name = name;
        listNeighbors = new TreeMap();
    }

    public Map<Item, Integer> getListNeighbors() {
        return listNeighbors;
    }

    public String getName() {
        return name;
    }

    public boolean isChoosed() {
        return choosed;
    }

    public void setChoosed(boolean choosed) {
        this.choosed = choosed;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Item s) {
        return this.name.compareTo(s.getName());
    }
}
