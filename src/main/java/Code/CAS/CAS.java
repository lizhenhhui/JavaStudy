package Code.CAS;



class CAS{
    private int value;
    //获取内存值
    public synchronized int get(){
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expectedValue, int newValue){
        //在设置新值之前先从内存中拿出旧值
        int oldValue = value;
        //如果预估值与旧值相等，则设置
        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;//返回内存中的数值
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue){
        //如果预期值等于内存中的数值则说明设置成功
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }

    public static void main(String[] args) {
        final CAS cas = new CAS();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = cas.get();//获取旧值
                    //生成随机数并设置，如果设置成功则返回true，否则返回false
                    boolean b = cas.compareAndSet(expectedValue, (int)(Math.random() * 101));
                    System.out.println(b);
                }
            }).start();
        }

    }

}