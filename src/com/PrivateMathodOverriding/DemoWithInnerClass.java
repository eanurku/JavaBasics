package com.PrivateMathodOverriding;

class parent {
    private void fun() {
        System.out.println("inside parent fun()");
    }

    class innerChild extends parent {
        private void fun() {
            System.out.println("inside innerchild fun()");
        }


    }

    public static void main(String[] args) {
        parent pobj=new parent();
        innerChild innerobj = pobj.new innerChild();
        pobj.fun();
        pobj=innerobj;
        pobj.fun();



    }
}


