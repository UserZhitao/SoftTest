public class Package {
    double length;
    double width;
    double height;
    double weight;
    double count;
    void AddPackage(double length,double width,double height,double weight)
    {
        this.length = length;
        this.width = width;
        this.height = height;
        this.weight = weight;
        //this.count = count;
    }

    double getSum(double length ,double width, double height)
    {
        return  this.length +this.width+this.height;
    }
    void  setLength(double length)
    {
        this.length = length;
    }
    double getLength()
    {
        return  this.length;
    }
    void setWidth(double width)
    {
        this.width = width;
    }

    double getWidth()
    {
        return this.width;
    }
    void setHeight(double height)
    {
        this.height = height;
    }
    double getHeight()
    {
        return this.height;
    }

    void setWeight(double weight)
    {
        this.weight = weight;
    }
    double getWeight()
    {
        return this.weight;
    }
    void setCount(double count)
    {
        this.count = count;
    }
    double getCount()
    {
        return this.count;
    }
}
