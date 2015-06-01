package com.fred.common.timer;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fred.common.timer.entity.Warning;

/**
 * Ԥ��ִ����
 * �ڸ����в�ѯ�������õ�����Ԥ����������ִ��Ԥ����Ϣ
 * @author ���鶫
 */
public class WarnTask extends TimerTask {

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void run() {
		try {
			this.cleanup();
			List<Warning> warningList = this.retriveAll();
			if(warningList.size()>0){				
				for(Warning warning : warningList){
					this.method102(warning);//2Ϊ��ͬ����
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �����ͳ�ƹ�������
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	private void cleanup(){
		String jpql = " delete from WarningContent";
//		JPAUtil.executeUpdate(jpql);
		System.out.println(jpql);
	}

	/**
	 * 101����˾��ͬ����
	 * @param partyId
	 */
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void method101(Warning warning){
		//��ѯ�������ں�ͬ
/*		List<Contract> contracts = contractService.retrieveContractOver(warning.getWarningDay().intValue());
		List<WarningContent> contentList = new ArrayList<WarningContent>();
		List<Long> warnPerIdLs = HyCommonUtil.paraseIds(warning.getLoginIds());
			for(Contract contract:contracts){
				for(Long warPerId : warnPerIdLs){
					WarningContent content = new WarningContent();
					Long contentId = SequenceUtil.genEntitySequenceNo(WarningContent.class);
					content.setContentId(contentId);
					content.setWarningId(warning.getWarningId());
					content.setContentDate(HyCommonUtil.getDate());
					content.setObjectType(warning.getLoginType());
					content.setWarnObject(warPerId);
					content.setContent("��ʾ��"+contract.getName()+"��ͬ��������.");
					contentList.add(content);
			}
		}
		JPAUtil.create(contentList);*/
	}
	 
	public List<Warning> retriveAll(){
		List<Warning> warnLs = new ArrayList<Warning>();
		Warning warn1 = new Warning(1L,"��ľ","�ú���ϰ��͵��");
		Warning warn2 = new Warning(2L,"��ʱ","victory need sacrifice!");
		warnLs.add(warn1);
		warnLs.add(warn2);
		return warnLs;
	}
	
	private void method102(Warning warning){
		System.out.println("���Ϊ��"+warning.getWarningId()+"�����ѣ�������Ϊ:"+warning.getWarningName()
				+",����Ϊ��"+warning.getWarningDescribe());
	}
}
