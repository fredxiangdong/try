package com.fred.thread;

class ThreadUseRunnable implements Runnable

//ͨ��ʵ��Runnable�ӿ��е�run()����,�������ʵ����run()��������
//Ϊ��������Thread���߳�ʵ��
{
      //Thread thread2 = new Thread(this);
      //�����ʵ����Runnable�ӿ���run()��������Ϊ��������Thread����߳�ʵ��
      ThreadUseRunnable(){}//���캯��
      public void run()
      {
          System.out.println("����Thread����߳�ʵ������ʵ����Runnable�ӿڵ���Ϊ����!");
          System.out.println("�ҽ�����1��!");
          System.out.println("�ص����߳�,���Ե�,�ղ����̹߳�����ܻ�û�ѹ�����");
          try
          {
              Thread.sleep(1000);//����1��
          }
          catch (InterruptedException e)
          {
              return;
          }
          //�����run()����˳��ִ������,�߳̽��Զ�����,�����ᱻ���߳�ɱ��
          //���������ʱ�����,���̻߳����,���ܱ�stop()ɱ��
      }
//�ó���������޸��������ʱ������ȼ�setPriority()    
}