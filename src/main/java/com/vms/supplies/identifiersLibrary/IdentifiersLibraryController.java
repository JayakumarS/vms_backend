package com.vms.supplies.identifiersLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/api/crew/IdentifiersLibrary")
public class IdentifiersLibraryController {
	
	@Autowired
	IdentifiersLibraryService IdentifiersLibraryService;
	
	@RequestMapping(value="/save")
	public IdentifiersLibraryResultBean save(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/savestorage")
	public IdentifiersLibraryResultBean savestorage(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.savestorage(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/savefunction")
	public IdentifiersLibraryResultBean savefunction(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.savefunction(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/saveitemdelilvery")
	public IdentifiersLibraryResultBean saveitemdelilvery(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.saveitemdelilvery(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/list")
	public IdentifiersLibraryResultBean list() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getList();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/liststorage")
	public IdentifiersLibraryResultBean liststorage() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getList1();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	@RequestMapping(value="/listfunction")
	public IdentifiersLibraryResultBean listfunction() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getList2();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/listdelivery")
	public IdentifiersLibraryResultBean listdelivery() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService. getList3();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/codemax")
	public IdentifiersLibraryBean codemax() {
		IdentifiersLibraryBean rbean = new IdentifiersLibraryBean();
		try {
			rbean = IdentifiersLibraryService.getCodemax();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	
	@RequestMapping(value="/edit")
	public IdentifiersLibraryResultBean edit(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.edit(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	@RequestMapping(value="/editstorage")
	public IdentifiersLibraryResultBean editstorage(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editstorage(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	
	@RequestMapping(value="/editfunction")
	public IdentifiersLibraryResultBean editfunction(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editfunction(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editdelivery")
	public IdentifiersLibraryResultBean editdelivery(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editdelivery(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	
	@RequestMapping(value="/update")
	public IdentifiersLibraryResultBean update(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.update(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatestorage")
	public IdentifiersLibraryResultBean updatestorage(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatestorage(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	

	@RequestMapping(value="/updatefunction")
	public IdentifiersLibraryResultBean updatefunction(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatefunction(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatedelivery")
	public IdentifiersLibraryResultBean updatedelivery(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatedelivery(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping("/getSequenceCode")
	public @ResponseBody IdentifiersLibraryBean getSequenceCode() {
		IdentifiersLibraryBean getSequenceCode = null;

	   getSequenceCode = IdentifiersLibraryService.getSequenceCode();

		return getSequenceCode;
	}
	
	@RequestMapping(value="/delete")
	public IdentifiersLibraryResultBean delete(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.delete(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/deletestorage")
	public IdentifiersLibraryResultBean deletestorage(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletestorage(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/deletefunction")
	public IdentifiersLibraryResultBean deletefunction(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletefunction(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	@RequestMapping(value="/deletedelivery")
	public IdentifiersLibraryResultBean deletedelivery(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletedelivery(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
