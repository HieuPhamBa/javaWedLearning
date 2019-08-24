var ketqua = document.getElementById('pre_screen');
var dis = document.getElementById('main_screen');
var end = false;
var doi_dau = false;
var doi_phep_tinh = false;
var phep_tinh_cu = '';
var uu_tien = 0;
var mang_so_max_index = 0;
var mang_so = new Array();
var mang_pt_max_index = 0;
var mang_pt = new Array();
var str_ketqua = '';
var phim_moi = '';

function ClickButton(obj){
	
	if(end){
		ketqua.value = '';
		end = false;
	}
	dis.value = '';
	// Chuỗi hiện tại của kết quả
	if(str_ketqua=='' && phim_moi == ''){
		str_ketqua = ketqua.value;
	}
	if(str_ketqua=='0'){
		str_ketqua = '';
	}
	
	// HTML của phím bấm
	var type = obj.innerHTML;
	
	// NHÓM SỐ
	if(	type=='0' ||
		type=='1' ||
		type=='2' ||
		type=='3' ||
		type=='4' ||
		type=='5' ||
		type=='6' ||
		type=='7' ||
		type=='8' ||
		type=='9' ||
		type=='+/-' ||
		type=='.')
	{
		doi_phep_tinh = false;
		// đổi dấu
		if(type=='+/-'){
			// Đổi từ - thành +
			if(doi_dau){
				doi_dau = false;
				phim_moi = phim_moi.substring(1);
			}
			// Đổi từ + thành -
			else
			{
				doi_dau = true;			
				phim_moi = '-' + phim_moi;
			}
		}
		// Số
		else
		{
			phim_moi += type;
		}
		// Thay đổi hiển thị
		ketqua.value = str_ketqua + phim_moi;
	}
	// NHÓM PHÉP TÍNH ( + - * / )
	else if(
		type=='+' ||
		type=='-' ||
		type=='x' ||
		type=='/'
	)
	{
		// Trước đó có bấm 1 phép tính
		if(doi_phep_tinh){
			// Nếu phép tính cũ là ưu tiên, nhưng phép tính mới không ưu tiên
			if((phep_tinh_cu=='' || phep_tinh_cu == '/') && (type == '+' || type == '-')){
				uu_tien--;
			}
			// Nếu phép tính cũ không ưu tiên, nhưng phép tính mới có ưu tiên
			else if((phep_tinh_cu=='+' || phep_tinh_cu == '-') && (type == 'x' || type == '/')){
				uu_tien++;
			}
			
			// Lưu vào mảng phép tính
			mang_pt[mang_pt_max_index-1] = type;
			// Xử lý hiển thị
			ketqua.value = ketqua.value.substring(0,ketqua.value.length-1) + type;			
		}
		// Chưa có bấm phép tính
		else{
			// Ghi nhớ phép tính
			phep_tinh_cu = type;
			
			// Lưu vào mảng số
			mang_so[mang_so_max_index] = parseFloat(phim_moi);		
			mang_so_max_index++;						
			
			// Lưu vào mảng phép tính
			mang_pt[mang_pt_max_index] = type;		
			mang_pt_max_index++;
			
			// Xử lý hiển thị
			ketqua.value = ketqua.value + type;
			
			// Cộng số đếm ưu tiên lên
			if(type=='x' || type == '/'){
				uu_tien++;
			}
		}
		// Ghi nhớ đã bấm phím phép tính
		doi_phep_tinh = true;
		// Đổi giá trị 2 chuỗi cơ bản về rỗng
		str_ketqua = '';
		phim_moi = '';
	}
	// NHÓM TÍNH KẾT QUẢ
	else if(type == '=' || type == '%')
	{		
		end	= true;
		if(phim_moi!=''){
			mang_so[mang_so_max_index] = parseFloat(phim_moi);
		}
		// Dấu =
		if(type == '='){			
			// ============
			// Gọi hàm tính
			// ============
			GetValue();
		}
		// Dấu %
		else
		{
			// ==============
			// Gọi hàm tính %
			// ==============
			GetPercent();
		}	
		
		// RESET
		str_ketqua = '';
		phim_moi = '';
		mang_so = new Array();
		mang_pt = new Array();
		mang_pt_max_index = 0;
		mang_so_max_index = 0;	
		uu_tien = 0;
	}
	// CE
	else if(type == 'CE'){
		phim_moi = '';
		// Thay đổi hiển thị
		ketqua.value = str_ketqua + phim_moi;
	}
	// Phím xóa 1 ký tự
	else
	{
		if(phim_moi.length > 1){
			phim_moi = phim_moi.substring(0, phim_moi.length-1);
		}else{
			phim_moi = '';
		}
		// Thay đổi hiển thị
		ketqua.value = str_ketqua + phim_moi;
	}	
}

// Tính %
function GetPercent(){
	mang_pt_max_index--;
	// Kiểm tra mảng số chỉ có 2 phần tử và phần tử thứ 2 phải khác 0
	if(mang_so_max_index!=1 || mang_so[1]==0){
		ketqua.value = "0";
	}
	// Phải có 1 phép tính
	else if(mang_pt_max_index!=0){
		ketqua.value = "0";
	}
	// Phép tính phải là chia
	else if(mang_pt[0] != '/'){
		ketqua.value = "0";
	}
	// Tất cả điều kiện đã vượt qua
	else{
		var _kq = mang_so[0] / mang_so[1] * 100;
		ketqua.value = _kq;
	}
	
	
}

// Tính giá trị thường
function GetValue(){
	mang_pt_max_index--;	
	
	// BƯỚC 1 : phép tính ưu tiên
	while(uu_tien>0){
		for(var index = 0 ; index <= mang_pt_max_index; index ++){
			if(mang_pt[index]=='x' || mang_pt[index]=='/'){
				// Lấy 2 số hạng
				var sh1 = mang_so[index];
				var sh2 = mang_so[index+1];
				// Tính kết quả * hoặc /
				var kqt = 0;
				if(mang_pt[index]=='x'){
					kqt = sh1 *  sh2;
				} 
				else if(sh2==0)
				{
					dis.value = "0";
				}
				else
				{
					kqt = sh1 /  sh2;
				}
				// Thay thế số hạng
				mang_so[index] = kqt;
				// Dồn số hạng
				for(var new_index = index + 1 ; new_index < mang_so_max_index ; new_index++){
					mang_so[new_index] = mang_so[new_index+1];					
				}
				mang_so_max_index--;
				
				// Xóa bỏ phép tính
				for(var new_index = index ; new_index < mang_pt_max_index ; new_index++){
					mang_pt[new_index] = mang_pt[new_index+1];					
				}
				mang_pt_max_index--;	
				uu_tien--;								
				break;
			}
		}
	}
	
	// BƯỚC 2	: phép tính thường
	while(mang_so_max_index>0){
		// Lấy 2 số hạng
		var sh1 = mang_so[0];
		var sh2 = mang_so[1];
		// Tính kết quả
		var kqt = 0;
		if(mang_pt[0]=='+'){
			kqt = sh1 + sh2;
		}else{
			kqt = sh1 - sh2;
		}
		// Thay thế số hạng
		mang_so[0] = kqt;
		// Dồn số hạng
		for(var new_index = 1 ; new_index < mang_so_max_index ; new_index++){
			mang_so[new_index] = mang_so[new_index+1];					
		}
		mang_so_max_index--;
		// Xóa bỏ phép tính
		for(var new_index = 0 ; new_index < mang_pt_max_index ; new_index++){
			mang_pt[new_index] = mang_pt[new_index+1];					
		}
		mang_pt_max_index--;
	}
	
	// IN KẾT QUẢ
	dis.value = mang_so[0];
}
