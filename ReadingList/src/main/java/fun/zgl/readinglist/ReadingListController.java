package fun.zgl.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ReadingList 前端控制器
 *
 * @author : zgl
 * @date : 2019-05-25
 */
@Controller
@RequestMapping(value = "/readingList")
public class ReadingListController {

    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController (ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader,
                               Model model){
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (null != readingList) {
            model.addAttribute("books",readingList);
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        // 重定向至上一个方法 ： redirect
        return "redirect:/readingList/{reader}";
    }
}
