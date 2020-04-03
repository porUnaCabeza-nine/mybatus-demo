package com.demo.test.listTest;

public class S {

    private String name;
    private String date;
    private int value;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((date == null) ? 0 : date.hashCode ());
        result = prime * result + ((name == null) ? 0 : name.hashCode ());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass () != obj.getClass ())
            return false;

        S other = (S) obj;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals ( other.date ))
            return false;

        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals ( other.name ))
            return false;
        return true;
    }

    static S merge(S s1, S s2) {
        if (!s1.equals ( s2 )) {
            throw new IllegalArgumentException ();
        }
        return new S ( s1.name, s1.date, s1.value + s2.value );
    }

    @Override
    public String toString() {
        return "S{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", value=" + value +
                '}';
    }

    public S(String name) {
        this.name = name;
    }

    public S(String name, String date, int value) {
        this.name = name;
        this.date = date;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
