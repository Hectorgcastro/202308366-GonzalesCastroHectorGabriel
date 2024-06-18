
/**
 * Write a description of class ListaCSE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaCSE<T>
{
    public NodoSE<T> ini ;
    
    public static void main(String[] args){
        ListaCSE list = new ListaCSE<Integer>();
        
        list.insertar(7);
        list.insertar(3);
        list.insertar(4);
        list.insertar(5);
        list.insertar(0);
        list.insertar(2);
        list.insertar(8);
        System.out.println("Lista Ejemplo");
        System.out.println(String.join("",list.print()));
        list.swap(1,6);
        System.out.println("List after swap(1,6):");
        System.out.println(String.join("",list.print()));
    }
    
    public void insertar(T dato){
        NodoSE<T> p,ult;
        p = new NodoSE<T>(dato);
        
        if(vacia()){
            ini = p;
            ini.setSuc(ini);
        }else{
            ult = getUlt(ini);
            ult.setSuc(p);
            p.setSuc(ini);
        }
    }
    
    private NodoSE<T> getUlt(NodoSE<T> a){
        NodoSE<T> res;
        if(a.getSuc() == ini){
            res = a;
        }else{
            res = getUlt(a.getSuc());
        }
        return res;
    }
    
    public void swap(int pos1,int pos2){
        if(!vacia()){
            NodoSE<T> elem1 = buscar(ini,pos1);
            NodoSE<T> elem2 = buscar(ini,pos2);
            T         aux   = elem1.getDato();
            if(elem1.getDato() != elem2.getDato()){
                elem1.setDato(elem2.getDato());
                elem2.setDato(aux);
            }
        }
    }
    
    public String[] print(){
        String[] res = new String[longitud()];
        return print(ini,res,0);
    }
    
    private String[] print(NodoSE<T> i,String[] r,int a){
        if(!vacia()){
            if(i.getSuc() == ini){
                r[a] = i.getDato() + "";
            }else{
                r[a] = i.getDato() + "";
                r =  print(i.getSuc(),r,a+1);
            }
        }
        return r;
    }
    
    private int contar(NodoSE<T> a){
        int res =0;
        if(a.getSuc()==ini){
            res = 1;
        }else{
            res = contar(a.getSuc()) +1;
        }
        return res;
    }
    
    private int longitud(){
        int res;
        if(vacia()){
            res = 0;
        }else{
            res = contar(ini);
        }
        return res;
    }
    
    private NodoSE<T> buscar(NodoSE<T> q, int pos){
        NodoSE<T> nodo;
        if(pos == 0){
            nodo = q;
        }else{
            nodo = buscar(q.getSuc(), pos-1);
        }
        return nodo;
    }
    
    private boolean vacia(){
        return ini == null;
    }
}
