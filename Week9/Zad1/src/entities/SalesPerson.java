package entities;

public class SalesPerson
{
    private String name;
    private double salary;
    private int salesCount;

    public SalesPerson(String name, double salary, int salesCount)
    {
        this.name = name;
        this.salary = salary;
        this.salesCount = salesCount;
    }
    public void addBonus(double amount)
    {
        salary += amount;
    }
    public int getSalesCount()
    {
        return salesCount;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }
    public void printNumSales (SalesPerson obj){
        System.out.println(obj.getSalesCount());
    }
    @Override
    public String toString()
    {
        return String.format("name: %s, salary: %.2f salesCount: %d ",
                name, salary, salesCount);
    }
}