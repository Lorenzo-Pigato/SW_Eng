package Exercise.Exercise_8;

import java.util.LinkedList;
import java.util.List;

import java.util.Iterator;

/*
    Esercizio 5 / Database
    Si progetti la classe Database.

    👉  Deﬁnire la astratta classe Entity caratterizzato da
        un identiﬁcativo id e un metodo displayDetails( ).

    👉  Deﬁnire Person and Product che estendono Entity. Person ha attributi nome e
        cognome, mentre Product ha attributi nome e prezzo. Fare override del
        metodo displayDetails( ).

    👉  Deﬁnire la classe Database<T extends Entity> che salva una lista di Entity.
        Deﬁnire i metodi add, remove, ﬁnd (id), e displayAll.
        Fare overloading del metodo add per accettare anche una lista.

    👉 Rendere iterabile la classe Database (con Iterator<T>).
    
    👉 Rendere clonabile la classe Database con (Cloneable).
 */
public class Database<T extends Entity> implements Iterable<T>{
    private List<T> dataset = new LinkedList<>();

    public void add(T entity){
        dataset.add(entity);
    }

    public void add(List<T> entityList){
        for (T entity : entityList) {
            dataset.add(entity);
        }
    }
    
    public void remove(T entity){
        dataset.remove(entity);
    }

    public T find(String id){
        for (T data : dataset) {
            if (data.getId().equals(id))
                return data;
        }

        return null;
    }

    public void displayAll(){
        for(T data: dataset) {
            data.displayDetails();
        }
        System.out.println("-------");
    }

    // Iterator
    @Override
    public Iterator<T> iterator(){
        return new DatabaseIterator<T>(this.dataset);
    }
}


// Iterator definition

class DatabaseIterator<T> implements Iterator<T> {
    private List<T> dataset;
    private int index = 0;

    public DatabaseIterator (List<T> dataset){
        this.dataset = dataset;
    }

    @Override
    public boolean hasNext() {
        if(dataset.get(index++) != null) 
            return true;
        return false;
    }

    @Override
    public T next() {
        return dataset.get(index);
    }
    
}
