package ua.automatisationInc.pos.controller;

import org.springframework.stereotype.Controller;

@Controller
public class KitchenController {

//
//    @Autowired
//    KitchenService kitchenService;
//    @Autowired
//    CashierService cashierService;
//
//    @RequestMapping(path = "/kitchen", method = RequestMethod.GET)
//    public String getKitchenPage(Model model) {
//        List<Bill> bills = new ArrayList<>();
//        for (Bill bill : kitchenService.showAllOrders()) {
//            if (bill.getStatus().equals(BillStatus.DO)) {
//                bills.add(bill);
//            }
//        }
//        model.addAttribute("bills", bills);
//        return "/kitchen";
//    }
//
//    @RequestMapping(path = "/kitchen", method = RequestMethod.POST)
//    public String edit(@RequestParam(name = "id", required = false) Long id) {
//        Bill bill = cashierService.getBill(id);
//        bill.setStatus(BillStatus.DONE);
//        cashierService.saveBill(bill);
//        return "redirect:/kitchen";
//    }
}
