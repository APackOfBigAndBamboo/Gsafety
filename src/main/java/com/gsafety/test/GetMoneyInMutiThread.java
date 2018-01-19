package com.gsafety.test;


class GetMoney implements Runnable {
    private GetMoneyInMutiThread account;
    private int cash;

    public GetMoney(GetMoneyInMutiThread account, int cash) {
        this.account = account;
        this.cash = cash;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        thread.setName("孔凡辉先生的姐姐");
        String name = Thread.currentThread().getName();
        System.out.println("线程\"" + name + "\"开始取钱！");
        account.getMoneyOutOfBank(cash);
        System.out.println("线程\"" + name + "\"取钱完毕！");
    }
}




class CurrentThreadNamePrinter{
    void printCurrentThreadName(){
        Thread currentThread=Thread.currentThread();
        currentThread.setName("亚杰");
        String threadName=currentThread.getName();
        System.out.println("执行代码的线程名叫做:"+threadName);
    }
}

public class GetMoneyInMutiThread {

    public static void main(String[] args) {
        GetMoneyInMutiThread account = new GetMoneyInMutiThread();
        account.putMoneyToBank(100);
        GetMoney money1 = new GetMoney(account, 100);
        GetMoney money2 = new GetMoney(account, 100);
        GetMoney money3 = new GetMoney(account, 100);

        Thread moneyThread1 = new Thread(money1, "取钱线程1");
        Thread moneyThread2 = new Thread(money2, "取钱线程2");
        Thread moneyThread3 = new Thread(money3, "取钱线程3");
        moneyThread1.start();
        moneyThread2.start();
        moneyThread3.start();

//        //这里调用打印线程名字的线程类CurrentThreadNamePrinter
//        Runnable runnable = new Runnable() {
//            public void run() {
//                CurrentThreadNamePrinter printer = new CurrentThreadNamePrinter();
//                printer.printCurrentThreadName();
//
//            }
//        };
//        Thread thread = new Thread(runnable, "线程-1");
//        thread.start();
//
//        //这里调用5秒钟内计算出下面两个整数的和1000毫秒
//        account.fiveMiao();
//        //这里调用5秒钟内计算出下面两个整数的和5000毫秒
//        account.giveAddingTest();
    }



    //方法区分标志位
    private int money = 0;

    public synchronized void getMoneyOutOfBank(int cash) {
        if (cash <= 0) {
            System.out.println("取钱数额必须大于0");
            return;
        }
        if (money < cash) {
            System.out.println("现金不足！");
            return;
        }
        System.out.println("正在处理，请稍后……");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
            return;
        }
        money = money - cash;
        System.out.println("取钱成功，孔凡辉先生请拿好现金：" + cash + "元。您现在帐户余额为：" + money + "元。");
    }

    public void putMoneyToBank(int cash) {
        if (cash <= 0) {
            System.out.println("存钱数额必须大于0");
            return;
        }
        System.out.println("正在处理存钱操作，请稍候……");
        int tempMoney = money + cash;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
            return;
        }
        money = tempMoney;
        System.out.println("孔凡辉先生存钱成功，金额为：" + cash + "元。您现在帐户余额为：" + money + "元。");
    }

    public void peekMoney() {
        System.out.println("您现在帐户余额为：" + money + "元。");
    }

    //方法区分标志位
    public  void fiveMiao( ) {
        int a = (int) (10* Math.random());
        int b = (int) (10 * Math.random());
        System.out.println("请在5秒钟内计算出下面两个整数的和：" + a + "+" + b);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
        }
        int result = a + b;
        System.out.println(a + "+" + b + "的运算结果是" + result);
    }


    //方法区分标志位
    public void giveAddingTest() {
        int a = (int) (100 * Math.random());
        int b = (int) (100 * Math.random());
        System.out.println("请在5秒钟内计算出下面两个整数的和：" + a + "+" + b);
        String currThreadName = Thread.currentThread().getName();
        System.out.println("执行当前代码的线程名叫做：" + currThreadName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
        }
        int result = a + b;
        System.out.println(a + "+" + b + "的运算结果是" + result);
    }

}






	/*又一个程序*/
//	private int times;
//	public CurrentThreadMainII(int times){
//		this.times=times;
//	}
//	public void run(){
//		for(int i=0;i<times;i++){
//			String content=this.getName()+"\t:\t"+i;
//			try{
//				this.sleep(1);
//			}catch(InterruptedException e){
//				System.out.println("对不起，运行出错");
//
//		}
//		System.out.println(content);
//		}
//		System.out.println("线程\""+this.getName()+"\"结束了。");
//	}
//
//	public static void main(String[] args){
//		CurrentThreadMainII ct1=new CurrentThreadMainII(6);
//		CurrentThreadMainII ct2=new CurrentThreadMainII(4);
//		ct1.setName("david");
//		ct2.setName("jie");
//		ct1.start();
//		ct2.start();
//		System.out.println("主线程结束了。");
//	}
//
//	}
//
//
//
//		/*private String name;*/
//
//		public CurrentThreadMainII(String name) {
//			this.name = name;
//		}
//
//		public String getName() {
//			return name;
//		}
//
//		public synchronized void copyPages(int pages) {
//			Thread employee = Thread.currentThread();
//			String th=employee.getName();
//			System.out.println(employee.getName() + "\t正在使用复印机\t" + name);
//
//			long time = pages * 1000;
//			try {
//				Thread.sleep(time);
//			} catch (InterruptedException e) {
//				System.out.println("对不起，程序运行出错，错误信息为：" + e.getMessage());
//			}
//			System.out.println(employee.getName() + "\t用完了复印机\t" + name);
//		}
//
//
//public static void main(String[] args){
//	CurrentThreadMainII jie =new CurrentThreadMainII("佳能");
//
//	Thread employee=new Thread("yajie");
//	jie.copyPages(10);
//	jie.getName();
//	Employee ta=new Employee("孔亚杰",5,jie);
//	Employee nvta=new Employee("黄大卫",2,jie);
//	ta.run();
//	nvta.run();
//}
//}
//
//
// class Employee extends Thread {
//
//	private int workTimes;
//	private CurrentThreadMainII jie;
//
//	public Employee(String name, int workTimes, CurrentThreadMainII jie) {
//		super(name);
//		this.workTimes = workTimes;
//		this.jie = jie;
//	}
//
//	public void run() {
//		System.out.println(this.getName() + "：开始工作。");
//		for (int i = 0; i < workTimes; i++) {
//			int pageAmount = (int) (10 * Math.random());
//			System.out.println("\"" + this.getName() + "\"尝试调用\""
//					+ jie.getName() + "\"的copyPages方法");
//			jie.copyPages(pageAmount);
//		}
//		System.out.println(this.getName() + "：完成了工作，下班。");
//	}
//
//}