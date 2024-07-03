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
	
	//location
	
	@RequestMapping(value="/listlocation")
	public IdentifiersLibraryResultBean listlocation() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService. getLocationlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/savelocation")
	public IdentifiersLibraryResultBean savelocation(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.savelocation(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editlocation")
	public IdentifiersLibraryResultBean editlocation(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editlocation(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatelocation")
	public IdentifiersLibraryResultBean updatelocation(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatelocation(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deletelocation")
	public IdentifiersLibraryResultBean deletelocation(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletelocation(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	//luboil
	
	@RequestMapping(value="/listluboil")
	public IdentifiersLibraryResultBean listluboil() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getLuboillist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/saveluboil")
	public IdentifiersLibraryResultBean saveluboil(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.saveluboil(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editluboil")
	public IdentifiersLibraryResultBean editluboil(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editluboil(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateluboil")
	public IdentifiersLibraryResultBean updateluboil(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updateluboil(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteluboil")
	public IdentifiersLibraryResultBean deleteluboil(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deleteluboil(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	//payment terms
	
	@RequestMapping(value="/listpayment")
	public IdentifiersLibraryResultBean listpayment() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getPaymentlist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/savepayment")
	public IdentifiersLibraryResultBean savepayment(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.savepayment(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editpayment")
	public IdentifiersLibraryResultBean editpayment(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editpayment(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatepayment")
	public IdentifiersLibraryResultBean updatepayment(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatepayment(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deletepayment")
	public IdentifiersLibraryResultBean deletepayment(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletepayment(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	//suplier(office)evaluation subfactors
	
	@RequestMapping(value="/listoffice")
	public IdentifiersLibraryResultBean listoffice() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getOfficelist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/saveoffice")
	public IdentifiersLibraryResultBean saveoffice(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.saveoffice(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editoffice")
	public IdentifiersLibraryResultBean editoffice(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editoffice(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updateoffice")
	public IdentifiersLibraryResultBean updateoffice(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updateoffice(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deleteoffice")
	public IdentifiersLibraryResultBean deleteoffice(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deleteoffice(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}
	
	//supplier evaluation scores
	
	@RequestMapping(value="/listscores")
	public IdentifiersLibraryResultBean listscores() {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.getScoreslist();
		} catch (Exception e) {
			e.printStackTrace();
		}
   		return rbean;
   	}
	
	@RequestMapping(value="/savescores")
	public IdentifiersLibraryResultBean savescores(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.savescores(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/editscores")
	public IdentifiersLibraryResultBean editscores(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.editscores(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/updatescores")
	public IdentifiersLibraryResultBean updatescores(@RequestBody IdentifiersLibraryBean bean) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.updatescores(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
	}
	
	@RequestMapping(value="/deletescores")
	public IdentifiersLibraryResultBean deletescores(@RequestParam("id") int id) {
		IdentifiersLibraryResultBean rbean = new IdentifiersLibraryResultBean();
		try {
			rbean = IdentifiersLibraryService.deletescores(id);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return rbean;
		
	}

}
