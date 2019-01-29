# Sheetdialog

1.使用方法在根目录中的build.gradle 
	
  allprojects {
  
		repositories {
    
			...
      
			maven { url 'https://jitpack.io' }
      
		}
    
	}
  
  2.加入依赖
  
  dependencies {
  
	        implementation 'com.github.zhihaoliang:Sheetdialog:Tag'
          
	}
  
  3.结果展示
  
   1> new ActionSheetDialog(MainActivity.this)
   
                        .builder()
                        
                        .setTitle("清空消息列表后，聊天记录依然保留，确定要清空消息列表？")
                        
                        .setCancelable(true)
                        
                        .setCanceledOnTouchOutside(true)
                        
                        .addSheetItem("清空消息列表", ActionSheetDialog.SheetItemColor.Red
                        
                                , new ActionSheetDialog.OnSheetItemClickListener() {
                                
                                    @Override
                                    
                                    public void onClick(int which) {
                                    
                                        //填写事件
                                        
                                    }
                                    
                                }).show();

 ![index]（https://github.com/zhihaoliang/Sheetdialog/blob/master/Screenshot_2019-01-29-14-47-38.png)


        
                                
