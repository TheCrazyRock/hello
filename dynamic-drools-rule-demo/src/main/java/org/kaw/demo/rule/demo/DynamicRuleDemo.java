

package org.kaw.demo.rule.demo;

import org.kie.api.runtime.KieSession;

public class DynamicRuleDemo {

    public static void main(String[] args) {
        
        
        System.out.println("************run rule 11111");
        DynamicRuleService.getInstance().buildRuleContent( "rule-123123123", "1.0.0",getRule11111111()); // 如果规则有变化，则调用此方法编译规则。 
        KieSession kSession = DynamicRuleService.getInstance().getRuleSession("rule-123123123", "1.0.0");
        kSession.setGlobal("out", System.out);
        kSession.insert(new Message("Dave", "Hello, HAL. Do you read me, HAL?"));
        kSession.fireAllRules();
        
        
        System.out.println("************run rule 22222");
        DynamicRuleService.getInstance().buildRuleContent("rule-456456456", "1.0.0", getRule2222222()); // 如果规则有变化，则调用此方法编译规则。 
        KieSession kSession2 = DynamicRuleService.getInstance().getRuleSession("rule-456456456", "1.0.0");
        kSession2.setGlobal("out", System.out);
        kSession2.insert(new Message("Dave", "Hello, Dog.  Do you read me, Dog?"));
        kSession2.fireAllRules();
        
        
        System.out.println("************run rule 11111 again ");
        kSession.insert(new Message("Dave", "Hello, HAL. Do you read me, HAL?"));
        kSession.fireAllRules();
        
        System.out.println("************run rule 22222 again ");
        kSession2.insert(new Message("Dave", "Hello, Dog.  Do you read me, Dog?"));
        kSession2.fireAllRules();
    }


    private static String getRule11111111() {
        String s = "" +
                   "package org.kaw.demo.rule.demo \n\n" +
                   "import org.kaw.demo.rule.demo.DynamicRuleDemo.Message \n\n" +
                   "global java.io.PrintStream out \n\n" +
                   "rule \"rule 1\" when \n" +
                   "    m : Message( ) \n" +
                   "then \n" +
                   "    out.println( m.getName() + \": \" +  m.getText() ); \n" +
                   "end \n" +
                   "rule \"rule 2\" when \n" +
                   "    Message( text == \"Hello, HAL. Do you read me, HAL?\" ) \n" +
                   "then \n" +
                   "    insert( new Message(\"HAL\", \"Dave. I read you.\" ) ); \n" +
                   "end";

        return s;
    }

    private static String getRule2222222() {
        String s = "" +
                   "package org.kaw.demo.rule.demo \n\n" +
                   "import org.kaw.demo.rule.demo.DynamicRuleDemo.Message \n\n" +
                   "global java.io.PrintStream out \n\n" +
                   "rule \"rule 0\" when \n" +
                   "    m : Message( ) \n" +
                   "then \n" +
                   "    out.println( m.getName() + \": \" +  m.getText() ); \n" +
                   "end \n" +
                   "rule \"rule 3\" when \n" +
                   "    Message( text == \"Hello, Dog.  Do you read me, Dog?\" ) \n" +
                   "then \n" +
                   "    insert( new Message(\"Dog\", \"Ignore any message.\" ) ); \n" +
                   "end";

        return s;
    }
    
    public static class Message {
        private String name;
        private String text;
        
        public Message(String name, String text) {
            this.text = text;
            this.name = name;
        }
        
        public String getText() {
            return text;
        }
        
        public void setText(String text) {
            this.text = text;
        }
        
        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }
    }

    
}
