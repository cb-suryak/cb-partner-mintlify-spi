## Steps to follow release(Chargebee owned)
1. Assume release is 0.0.9. (find release from git page release section)
2. create a new branch called release/<release> so this would be release/0.0.9
3. create new branch for ticket feat/<ticket-number>
4. commit to  feat/<ticket-number>
5. Raise PR from feat/<ticket-number> to release/0.0.9
6. After PR is approved and merged
7. Raise PR from release/0.0.9 to dev. Once PR is merged it will auto release the 0.0.9 version of SPI for dev code base
8. After that raise PR from release/0.0.9 to main. Once PR is merged it will auto release the 0.0.9 version of SPI for prod codebase