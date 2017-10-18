# SelectView
一个简单实现上弹菜单的View，样式仿照美团和微博

demo 
------- 
<div class='row'>
<img  width="250" height="445" src="https://github.com/PeanutFeng/SelectView/blob/master/demo1.gif"'/>
<img  width="250" height="445" src="https://github.com/PeanutFeng/SelectView/blob/master/demo2.GIF"'/>
</div>

导入 
-------
```Gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
dependencies {
    compile 'com.github.PeanutFeng:SelectView:1.0.0'
}
```

用法 
-------

```Java
selectView = new SelectView(this,ITEMTEXTS); //ITEMTEXTS为String数组，数组每个元素为上弹菜单中每个item的文字
selectView.setPositionListener(this);    //每个item设置点击事件监听器
selectView.setView();
selectView.showAtLocation(findViewById(R.id.rl), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); //rl为弹出菜单前的rootview,例如Relativelayout
```
```Java
//点击事件回调,position为点击上弹菜单某个item的position
  @Override
    public void positionSelected(int position) {
        if(selectView.isShowing()){
            selectView.dismiss();
        }
        switch (position){
           
        }
    }
```
