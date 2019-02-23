# -*- coding: utf-8 -*-
"""
Created on Fri Apr  8 16:54:36 2011

@author: ProfMobius
@version: v1.0
"""

import sys
import logging
from optparse import OptionParser

from commands import Commands, CLIENT, SERVER, CalledProcessError
from mcp import recompile_side


def main():
    parser = OptionParser(version='MCP %s' % Commands.fullversion())
    parser.add_option('-c', '--config', dest='config', help='additional configuration file')
    options, _ = parser.parse_args()
    recompile(options.config)


def recompile(conffile):
    try:
        commands = Commands(conffile, verify=True)

        try:
            recompile_side(commands, CLIENT)
        except CalledProcessError:
            pass
        try:
            recompile_side(commands, SERVER)
        except CalledProcessError:
            pass
    except Exception:  # pylint: disable-msg=W0703
        logging.exception('FATAL ERROR')
        sys.exit(1)


if __name__ == '__main__':
    main()
