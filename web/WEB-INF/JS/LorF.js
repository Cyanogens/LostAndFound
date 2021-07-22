
    /*返回顶部按钮*/
    function pageScroll() {
    window.scrollBy(0, -100);
    scrolldelay = setTimeout('pageScroll()', 100);
    var sTop = document.documentElement.scrollTop + document.body.scrollTop;
    if (sTop == 0) clearTimeout(scrolldelay);
}

    /*瀑布*/
    function aa() {
    var oMain = document.getElementById('main');
    var ITEM_WIDTH = 200;
    var ITEM_SPACE = 10;
    var itemArray = [];
    var itemHeight = [];

    // 求随机数
    function rand(min, max) {
    return parseInt(Math.random() * (max - min + 1) + min);
}


    function createItem(min, max) {
    for (var i = min; i < max; i++) {
    var div = document.createElement('div');
    div.style.borderRadius = '30px';
    div.style.border = '1px solid green';
    div.style.height = '300px';
    div.style.width = ITEM_WIDTH + 'px';
    div.style.backgroundColor = 'rgba(255,255,255,0)';
    oMain.appendChild(div);
    itemArray[i] = div;
}
    layout();
}

    createItem(0, 30);

    //div的布局
    function layout() {
    var t = 0;
    var l = 0;
    var frist = true;
    var mainWidth = 0;
    var winWidth = document.documentElement.clientWidth || document.body.clientWidth;

    for (var i = 0; i < itemArray.length; i++) {
    if ((l + ITEM_WIDTH) >= winWidth) {
    frist = false;
    mainWidth = l;
    l = 0;
}
    if (frist) {
    itemArray[i].style.top = t + 'px';
    itemArray[i].style.left = l + 'px';
    itemHeight[i] = itemArray[i].offsetHeight;
} else {
    var min = getMin(itemHeight);
    for (var j = 0; j < itemHeight.length; j++) {
    if (itemHeight[j] == min) {
    itemArray[i].style.top = min + ITEM_SPACE + 'px';
    itemArray[i].style.left = j * (ITEM_WIDTH + ITEM_SPACE) + 'px';
    itemHeight[j] += (itemArray[i].offsetHeight + ITEM_SPACE);
    break;
}
}
}
    l += ITEM_WIDTH + ITEM_SPACE;
}
    // oMain居中
    var w = mainWidth - ITEM_SPACE;
    oMain.style.width = w + 'px';
    oMain.style.left = (winWidth - w) / 2 + 'px';

}


    //求最小值
    function getMin(aArray) {
    var min = aArray[0];
    for (var i = 0; i < aArray.length; i++) {
    if (min > aArray[i]) {
    min = aArray[i];
}
}
    return min;
}

    window.onresize = function() {
    itemHeight = [];
    layout();
}


    // 滚动滚动条达到最长的一个hight时，加载出更多
    window.onscroll = function() {
    var scrollHeight = document.body.scrollTop || document.documentElement.scrollTop;
    var winHeight = document.body.clientHeight || document.documentElement.clientHeight;
    var max = Math.max.apply(null, itemHeight);
    var num = 0;
    if ((scrollHeight + winHeight) >= max - 30) {
    num = itemArray.length;
    createItem(num, num + 10);
}
}

}
    aa();