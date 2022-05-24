package expression;

import java.util.Hashtable;



public class SymbolTable {
    public Hashtable<String, Expression> HT;

     public SymbolTable(){
             HT = new Hashtable<String, Expression>(); 
    }

    public void enterNode(String id, Expression var) 
    {
        int hashedKeyValue = (id.length())%10;
        int attempt = 0;

        while (HT.containsKey(hashedKeyValue))
        {
            attempt++;
            hashedKeyValue = (id.length()+attempt)%10;
        }
        HT.put(hashedKeyValue, var);
    }

    public Variable retrieveNode(String id)
    {
        int hashedKeyValue = (id.length())%10;
        int attempt = 0;

        if (!HT.containsKey(hashedKeyValue))
        {
            return null;
        }
        else
            while(id != HT.get(hashedKeyValue).id) 
            {
                attempt++;
                hashedKeyValue = (id.length()+attempt)%10;
            }
        return HT.get(hashedKeyValue);
    }
}
    
    
    