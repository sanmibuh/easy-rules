/*
 * The MIT License
 *
 *  Copyright (c) 2013, benas (md.benhassine@gmail.com)
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package net.benas.easyrules.core;

import net.benas.easyrules.util.EasyRulesConstants;

/**
 * Class representing a rule than can be fired by the rules engine.<br/>
 *
 * Rules are registered in the rules engine registry and must have a <strong>unique</strong> name.<br/>
 *
 * Rules are fired according to their priority. By default, lower values represent higher priorities. To override
 * this default behavior, override {@link net.benas.easyrules.core.Rule#compareTo(net.benas.easyrules.core.Rule)} and
 * provide custom priority strategy.
 *
 * @author benas (md.benhassine@gmail.com)
 */
public class Rule implements Comparable<Rule> {

    /**
     * Rule name.
     */
    private String name;

    /**
     * Rule description.
     */
    private String description;

    /**
     * Rule priority.
     */
    private int priority;

    public Rule() {
        this.name = EasyRulesConstants.DEFAULT_RULE_NAME;
        this.description = EasyRulesConstants.DEFAULT_RULE_DESCRIPTION;
        this.priority = EasyRulesConstants.DEFAULT_RULE_PRIORITY;
    }

    public Rule(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
    }

    /**
     * Rule conditions abstraction : this method encapsulates the rule's conditions.
     * @return true if the rule should be applied, false else
     */
    public boolean evaluateConditions(){
        return false;
    }

    /**
     * Rule actions abstraction : this methods encapsulates the rule's actions.
     * @throws Exception thrown if an exception occurs during actions performing
     */
    public void performActions() throws Exception {
        //no op
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rule rule = (Rule) o;

        return name.equals(rule.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo(Rule rule) {
        if (priority < rule.getPriority()) {
            return -1;
        } else if (priority == rule.getPriority()) {
            return 0;
        } else {
            return 1;
        }
    }

}
