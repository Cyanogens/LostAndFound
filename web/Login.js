$(function () {
    document.onkeydown = keyDownSearch;

    function keyDownSearch(e) {
        // 兼容FF和IE和Opera
        var theEvent = e || window.event;
        var code = theEvent.keyCode || theEvent.which || theEvent.charCode;
        if (code === 13) {
            $('#submit').click();//具体处理函数
            return false;
        }
        return true;
    }
});