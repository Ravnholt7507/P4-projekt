package expression;

import java.util.Hashtable;



public class SymbolTable {
    public Hashtable <Integer, Variable> HT;

     public SymbolTable(){
             HT = new Hashtable<Integer, Variable>(); 
    }

    public void enterNode(Variable var) 
    {
        int hashedKeyValue = (var.id.length())%10;
        int attempt = 0;

        while (HT.containsKey(hashedKeyValue))
        {
            attempt++;
            hashedKeyValue = (var.id.length()+attempt)%10;
        }
        HT.put(hashedKeyValue, var);
    }

    public Variable retrieveNode(String name)
    {
        int hashedKeyValue = (name.length())%10;
        int attempt = 0;

        if (!HT.containsKey(hashedKeyValue))
        {
            return null;
        }
        else
            while(name != HT.get(hashedKeyValue).id) 
            {
                attempt++;
                hashedKeyValue = (name.length()+attempt)%10;
            }
        return HT.get(hashedKeyValue);
    }
}
    
    
    