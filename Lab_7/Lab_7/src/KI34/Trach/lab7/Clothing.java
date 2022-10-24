package KI34.Trach.lab7;

class Clothing implements Data
{
    private String clothingName;
    private int clothingSize;

    public Clothing(String cName, int cSize)
    {
        clothingName = cName;
        clothingSize = cSize;
    }

    public String getName()
    {
        return clothingName;
    }

    public void getFileName(String name)
    {
        clothingName = name;
    }

    public void SetSize(int n)
    {
        clothingSize = n;
    }


    public int getSize()
    {
        return clothingSize;
    }

    public int compareTo(Data p)
    {
        Integer s = clothingSize;
        return s.compareTo(p.getSize());
    }

    public void print()
    {
        System.out.print("Clothing name: " + clothingName + ", Clothing Size: " + clothingSize + ";\n");
    }
}