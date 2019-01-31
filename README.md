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
  
	        implementation 'com.github.zhihaoliang:Sheetdialog:v1.0'
          
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

 ![Ring-menu](https://github.com/zhihaoliang/Sheetdialog/blob/master/Screenshot_2019-01-29-14-47-38.png)
 
 
  2> new ActionSheetDialog(MainActivity.this)
  
                        .builder()
			
                        .setCancelable(true)
			
                        .setCanceledOnTouchOutside(true)
			
                        .addSheetItem("发送给好友",
			
                                ActionSheetDialog.SheetItemColor.Blue,
				
                                new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                })
				
                        .addSheetItem("转载到空间相册",
			
                                ActionSheetDialog.SheetItemColor.Blue,
				
                                new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                })
				
                        .addSheetItem("上传到群相册",
			
                                ActionSheetDialog.SheetItemColor.Blue,
				
                                new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                })
				
                        .addSheetItem("保存到手机",
			
                                ActionSheetDialog.SheetItemColor.Blue,
				
                                new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                }).show();
				
 ![Ring-menu](https://github.com/zhihaoliang/Sheetdialog/blob/master/Screenshot_2019-01-29-14-48-07.png)
 
  3>  new ActionSheetDialog(MainActivity.this)
  
                        .builder()
			
                        .setTitle("好友列表")
			
                        .setCancelable(true)
			
                        .setCanceledOnTouchOutside(true)
			
                        .addSheetItem("删除好友", ActionSheetDialog.SheetItemColor.Red
			
                                , new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                })
				
                        .addSheetItem("增加好友", ActionSheetDialog.SheetItemColor.Blue
			
                                , new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                })
				
                        .addSheetItem("备注", ActionSheetDialog.SheetItemColor.Blue
			
                                , new ActionSheetDialog.OnSheetItemClickListener() {
				
                                    @Override
				    
                                    public void onClick(int which) {
				    
                                        //填写事件
					
                                    }
				    
                                }).show();
				
				
 ![Ring-menu](https://github.com/zhihaoliang/Sheetdialog/blob/master/Screenshot_2019-01-29-14-50-20.png)



        
                                
