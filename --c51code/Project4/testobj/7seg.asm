
;������ʵ���߶��붯̬��ʾ����
;///////////////////////////////////////////
			org	0000h
			ajmp	main
			org	0030h
main:
			mov dptr,#tab				;����ͷλ������DPTR      					
			mov 30h,#00h                ;��30H��λ��ʾ���嵥Ԫ����          
			mov 31h,#00h                ;��31Hʮλ��ʾ���嵥Ԫ����          
			mov 32h,#00h                ;��32H��λ��ʾ���嵥Ԫ����          
			mov 33h,#00h                ;��33Hǧλ��ʾ���嵥Ԫ����          
loop:
			mov r4,#5					;r4��Ϊ���������
tt1:
			lcall display				;������ʾ���� 
			djnz	r4,tt1				;r4��һ��Ϊ��,����tt1
			lcall update				;����ˢ����ʾ�ӳ���
			ajmp loop					;����loop,����ѭ����ʾ.

display:	               
			mov r7,#100					;�����������ֵ                         	
dd1:                                                                            
			mov a,30h                   ;����ʾ������30H�е�ֵ����ACC           
			movc a,@a+dptr              ;���ȡҪ��ʾ�������Ѳ��Ľ������ACC  
			mov p0,a                    ;��Ҫ��ʾ��������P0��                   
			clr p2.7                    ;����λ��ʾ��Ԫ                         
			lcall delay100us            ;��ʱ100US                              
			setb p2.7                   ;�ظ�λ��ʾ��                           
                                        	                                    
			mov a,31h                   ;����ʾ��������31H�е�ֵ����A           
			movc a,@a+dptr              ;���ȡҪ��ʾ�������Ѳ��Ľ������ACC  
			mov p0,a                    ;��Ҫ��ʾ��������P0��                   
			clr p2.6                    ;��ʮλ��ʾ��Ԫ                         
			lcall delay100us            ;��ʱ100US                              
			setb p2.6                   ;��ʮλ��ʾ��Ԫ                         
                                        	                                    
			mov a,32h                   ;����ʾ������32H�е�ֵ����ACC           
			movc a,@a+dptr              ;���ȡҪ��ʾ�������Ѳ��Ľ������ACC  
			mov p0,a                    ;��Ҫ��ʾ��������P0��                   
			clr p2.5                    ;����λ��ʾ��Ԫ                         
			lcall delay100us            ;��ʱ100US                              
			setb p2.5                   ;�ذ�λ��ʾ��Ԫ                         
                                        	                                    
			mov a,33h                   ;����ʾ������33H�е�ֵ����ACC           
			movc a,@a+dptr              ;���ȡҪ��ʾ�������Ѳ��Ľ������ACC  
			mov p0,a                    ;��Ҫ��ʾ��������P0��                   
			clr p2.4                    ;��ǧλ��ʾ��Ԫ                         
			lcall delay100us            ;��ʱ100US                              
			setb p2.4                   ;��ǧλ��ʾ��Ԫ                         
			djnz r7,dd1                 ;R7������0������DD1��                   
			ret                         ;R7����0�ӳ��򷵻�                      

update:									;ˢ����ʾ�ӳ���
			inc 30h						;��λ��ʾ���嵥Ԫ��һ		
			mov a,30h
			cjne a,#10,exit				;��û�ӵ�ʮ,�˳�
			mov 30h,#00h				;�ӵ�ʮ��,��λ����
			inc 31h						;ʮλ��ʾ���嵥Ԫ��һ		
			mov a,31h                                               
			cjne a,#10,exit             ;��û�ӵ�ʮ,�˳�            
			mov 31h,#00h                ;�ӵ�ʮ��,ʮλ����          
			inc 32h						;��λ��ʾ���嵥Ԫ��һ		
			mov a,32h                                               
			cjne a,#10,exit             ;��û�ӵ�ʮ,�˳�            
			mov 32h,#00h                ;�ӵ�ʮ��,��λ����          
			inc 33h						;ǧλ��ʾ���嵥Ԫ��һ		
			mov a,33h                                                                           
			cjne a,#10,exit             ;��û�ӵ�ʮ,�˳�            
			mov 33h,#00h                ;�ӵ�ʮ��,ǧλ����          
exit:
			ret							;ˢ����ʾ�ӳ��򷵻�

delay100us:
			mov r5,#50
			djnz	r5,$
			ret

delay10ms:
			mov r6,#100
tt2:
			mov r5,#50
			djnz r5,$
			djnz r6,tt2
			ret
			
tab:	   DB        003H;0
           DB        09FH;1
           DB        025H;2
           DB        00DH;3
           DB        099H;4
           DB        049H;5
           DB        041H;6
           DB        01FH;7
           DB        001H;8
           DB        009H;9 ;013456789������

           END
