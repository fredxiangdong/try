package com.fred.thread;

class ThreadUseExtends extends Thread
//ͨ���̳�Thread��,��ʵ�����ĳ��󷽷�run()
//�ʵ�ʱ�򴴽��� һ Thread�����ʵ����ʵ�ֶ��̻߳���
//һ���߳�������Ҳ���������״̬��һ�����CPU���Զ���������run()����
{
      
      ThreadUseExtends(){}//���캯��
      public void run()
      {
          System.out.println("����Thread������߳�ʵ��!");
          System.out.println("�ҽ�����10��!");
          System.out.println("�ص����߳�,���Ե�,�ղ����̹߳�����ܻ�û�ѹ�����");
          try
          {
        	  Thread.sleep(10000);//����10��
          }
          catch (InterruptedException e)
          {
              return;
          }
          //�����run()����˳��ִ������,�߳̽��Զ�����,�����ᱻ���߳�ɱ��
          //���������ʱ�����,���̻߳����,���ܱ�stop()ɱ��
      }
}
