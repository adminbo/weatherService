/**
 * Created by lenovo on 2017/4/20.
 */
//checkbox 全选/取消全选
var isCheckAll = false;
function swapCheck() {
    if (isCheckAll) {
        $(".check").each(function() {
            this.checked = false;
        });
        isCheckAll = false;
    } else {
        $(".check").each(function() {
            this.checked = true;
        });
        isCheckAll = true;
    }
}
