/*上传图片并显示*/
var _URL = window.URL || window.webkitURL;

function preview(file) {
    var prevDiv = document.getElementById('preview');
    if (file.files && file.files[0]) {
        var reader = new FileReader();
        reader.onload = function (evt) {
            prevDiv.innerHTML = '<img id="imgnode" src="' + evt.target.result + '" />';
            console.log(evt.target.result)
        }
        reader.readAsDataURL(file.files[0]);
    } else {
        prevDiv.innerHTML = '<div class="img" id="imgnode"  style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
    }
}