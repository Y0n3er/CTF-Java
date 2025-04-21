package org.dubhe.javolution.controller;

import org.dubhe.javolution.model.Pal;
import org.dubhe.javolution.service.PalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.InetAddress;

@RestController
@RequestMapping("/pal")
public class PalController
{
    PalService palService = new PalService();

    @RequestMapping("/")
    public String index()
    {
        return "Welcome to PalWorld !";
    }

    @RequestMapping("/show")
    public String show()
    {
        String result;
        try {
            result = palService.showPal();
        } catch (Exception e) {
            return "Error";
        }
        return result;
    }

    @RequestMapping("/battle")
    public String battle()
    {
        return "Try to beat Jetragon and Capture The Flag !";
    }

    @RequestMapping("/battle/{boss}")
    public ResponseEntity<?> battle(@PathVariable String boss)
    {
        try {
            Pal opponent = palService.getPal(boss);
            if (opponent == null) {
                return new ResponseEntity<>("Opponent not found.", HttpStatus.NOT_FOUND);
            }
            int result = palService.battle(palService.getPlayer(), opponent);
            if (result >= 0) {
                palService.levelUp(opponent.getLevel());
                return new ResponseEntity<>("You win against " + opponent.getName() + ", congratulations !", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("You lose against " + opponent.getName() + ", try again.", HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/capture")
    public String capture(String name)
    {
        Pal pal = palService.getPal(name);
        if (pal == null) {
            return "Pal not found";
        }
        if (palService.getPlayer().getLevel() + 10 < pal.getLevel()) {
            return "Your level is too low to capture " + pal.getName();
        }
        palService.setPlayer(pal);
        return "You have successfully captured " + pal.getName();
    }

    @GetMapping("/cheat")
    public String cheat(@RequestParam(required = false) Integer hp,
                        @RequestParam(required = false) Integer attack,
                        @RequestParam(required = false) Integer defense)
    {
        if (hp != null) {
            palService.getPlayer().setHp(hp);
        }
        if (attack != null) {
            palService.getPlayer().setAttack(attack);
        }
        if (defense != null) {
            palService.getPlayer().setDefense(defense);
        }

        return "Wow, you have found the backdoor, check your Pal right now !";
    }

    @PostMapping("/cheat")
    public String cheatPlus(String host,String data)
    {
        String secretKey = "dubhe";
        InetAddress address;
        boolean local;
        if (palService.getPlayer().getLevel() >= 50 && host!=null) {
            try {
                address = InetAddress.getByName(host);
                local = address.isLoopbackAddress();
            }
            catch (Exception e) {
                return "Bad Host!";
            }
            if (local && host.contains(secretKey)) {
                palService.genPal(data);
                return "You are now invincible !";
            } else {
                return "Only localhost is allowed to cheat !";
            }
        } else {
            return "You are too young to cheat !";
        }
    }
}
