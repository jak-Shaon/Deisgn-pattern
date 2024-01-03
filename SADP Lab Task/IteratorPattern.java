interface Container
{
    public Iterator getIterator();
}
interface Iterator 
{
    public boolean hasNext();
    public Object nxt();
}

class NameRepo implements Container
{
    public String names[] = {"Jak","Faraha","Shaon","Takia"};

    @Override
    public Iterator getIterator()
    {
        return new NameIter();
    }

    private class NameIter implements Iterator
    {
        int index;
        @Override
        public boolean hasNext()
        {
            if(index<names.length)
            {
                return true;
            }
            return false;
        }

        @Override
        public Object nxt()
        {
            if(this.hasNext())
            {
                return names[index++];
            }
            return null;
        }
    }
}

class IteratorPattern
{
    public static void main(String[] args) {
        NameRepo nameRepo = new NameRepo();

        for(Iterator iter = nameRepo.getIterator(); iter.hasNext();)
        {
            String name = (String)iter.nxt();
            System.out.println("Name : "+name);
        }
    }
}