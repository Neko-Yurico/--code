
;本程序实现七段码动态显示功能
;///////////////////////////////////////////
			org	0000h
			ajmp	main
			org	0030h
main:
			mov dptr,#tab				;将表头位置送入DPTR      					
			mov 30h,#00h                ;将30H个位显示缓冲单元清零          
			mov 31h,#00h                ;将31H十位显示缓冲单元清零          
			mov 32h,#00h                ;将32H百位显示缓冲单元清零          
			mov 33h,#00h                ;将33H千位显示缓冲单元清零          
loop:
			mov r4,#5					;r4作为软件计数器
tt1:
			lcall display				;调用显示程序 
			djnz	r4,tt1				;r4减一后不为零,返回tt1
			lcall update				;调用刷新显示子程序
			ajmp loop					;跳回loop,继续循环显示.

display:	               
			mov r7,#100					;软件计数器赋值                         	
dd1:                                                                            
			mov a,30h                   ;将显示缓冲区30H中的值送入ACC           
			movc a,@a+dptr              ;查表取要显示的数并把查表的结果送入ACC  
			mov p0,a                    ;将要显示的数送入P0口                   
			clr p2.7                    ;开个位显示单元                         
			lcall delay100us            ;延时100US                              
			setb p2.7                   ;关个位显示单                           
                                        	                                    
			mov a,31h                   ;将显示缓冲区别31H中的值送入A           
			movc a,@a+dptr              ;查表取要显示的数并把查表的结果送入ACC  
			mov p0,a                    ;将要显示的数送入P0口                   
			clr p2.6                    ;开十位显示单元                         
			lcall delay100us            ;延时100US                              
			setb p2.6                   ;关十位显示单元                         
                                        	                                    
			mov a,32h                   ;将显示缓冲区32H中的值送入ACC           
			movc a,@a+dptr              ;查表取要显示的数并把查表的结果送入ACC  
			mov p0,a                    ;将要显示的数送入P0口                   
			clr p2.5                    ;开百位显示单元                         
			lcall delay100us            ;延时100US                              
			setb p2.5                   ;关百位显示单元                         
                                        	                                    
			mov a,33h                   ;将显示缓冲区33H中的值送入ACC           
			movc a,@a+dptr              ;查表取要显示的数并把查表的结果送入ACC  
			mov p0,a                    ;将要显示的数送入P0口                   
			clr p2.4                    ;开千位显示单元                         
			lcall delay100us            ;延时100US                              
			setb p2.4                   ;关千位显示单元                         
			djnz r7,dd1                 ;R7不等于0返回至DD1处                   
			ret                         ;R7等于0子程序返回                      

update:									;刷新显示子程序
			inc 30h						;个位显示缓冲单元加一		
			mov a,30h
			cjne a,#10,exit				;还没加到十,退出
			mov 30h,#00h				;加到十了,个位清零
			inc 31h						;十位显示缓冲单元加一		
			mov a,31h                                               
			cjne a,#10,exit             ;还没加到十,退出            
			mov 31h,#00h                ;加到十了,十位清零          
			inc 32h						;百位显示缓冲单元加一		
			mov a,32h                                               
			cjne a,#10,exit             ;还没加到十,退出            
			mov 32h,#00h                ;加到十了,百位清零          
			inc 33h						;千位显示缓冲单元加一		
			mov a,33h                                                                           
			cjne a,#10,exit             ;还没加到十,退出            
			mov 33h,#00h                ;加到十了,千位清零          
exit:
			ret							;刷新显示子程序返回

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
           DB        009H;9 ;013456789字形码

           END
