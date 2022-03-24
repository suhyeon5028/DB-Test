package site.metacoding.board.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import site.metacoding.board.domain.board.BoardRepository;

@RequiredArgsConstructor
@Controller
public class BoardController {

    private final BoardRepository boardRepository;

    @GetMapping({ "/", "/board/list" })
    public String list(@RequestParam(defaultValue = "") String keyword, Model model) {

        model.addAttribute("boards", boardRepository.mSearch(keyword));

        return "/board/list";
    }
}