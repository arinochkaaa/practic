package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

public class Sprint {
    private final int capacity;
    private final int ticketsLimit;
    private final Ticket[] tickets;
    private int currentEstimate;
    private int ticketCount;

    public Sprint(int capacity, int ticketsLimit) {
        this.capacity = capacity;
        this.ticketsLimit = ticketsLimit;
        this.tickets = new Ticket[ticketsLimit];
        this.currentEstimate = 0;
        this.ticketCount = 0;
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || !userStory.isCompleted() || ticketCount >= ticketsLimit ||
                currentEstimate + userStory.getEstimate() > capacity) {
            return false;
        }
        for (UserStory dependency : userStory.getDependencies()) {
            boolean found = false;
            for (int i = 0; i < ticketCount; i++) {
                if (tickets[i] == dependency) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        tickets[ticketCount++] = userStory;
        currentEstimate += userStory.getEstimate();
        return true;
    }

    public boolean addBug(Bug bug) {
        if (bug == null || !bug.isCompleted() || ticketCount >= ticketsLimit ||
                currentEstimate + bug.getEstimate() > capacity) {
            return false;
        }
        tickets[ticketCount++] = bug;
        currentEstimate += bug.getEstimate();
        return true;
    }

    public Ticket[] getTickets() {
        Ticket[] result = new Ticket[ticketCount];
        System.arraycopy(tickets, 0, result, 0, ticketCount);
        return result;
    }

    public int getTotalEstimate() {
        return currentEstimate;
    }
}
