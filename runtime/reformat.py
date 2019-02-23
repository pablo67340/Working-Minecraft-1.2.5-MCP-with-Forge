# -*- coding: utf-8 -*-
"""
Created on Thu Jan  19 12:34:12 2012

@author: Fesh0r
@version: v1.0
"""

import sys
import logging
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER, CalledProcessError
from mcp import reformat_side


def main():
    parser = OptionParser(version='MCP %s' % Commands.fullversion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    reformat(options.config)


def reformat(conffile):
    try:
        commands = Commands(conffile, verify=True)

        try:
            reformat_side(commands, CLIENT)
            reformat_side(commands, SERVER)
        except CalledProcessError:
            # astyle failed
            commands.logger.error('Reformat failed')
            sys.exit(1)
    except Exception:  # pylint: disable-msg=W0703
        logging.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
