package KI34.Trach.lab7;

class Thing implements Data
{
    private String thingName;
    private double thingWeight;
    private int thingSize;

    public Thing(String thName, double thWeight, int thSize)
    {
        thingName = thName;
        thingWeight = thWeight;
        thingSize = thSize;
    }

    public String getThingName()
    {
        return thingName;
    }

    public void setProgramName(String name)
    {
        thingName = name;
    }

    public double getWeight()
    {
        return thingWeight;
    }

    public void setWeight(double n)
    {
        thingWeight = n;
    }

    public int getSize()
    {
        return thingSize;
    }

    public int compareTo(Data p)
    {
        Integer s = thingSize;
        return s.compareTo(p.getSize());
    }

    public void print()
    {
        System.out.print("Thing: " + thingName + ", Thing Size: " + thingSize +
                ", Thing Weight: " + thingWeight + ";\n");
    }
}